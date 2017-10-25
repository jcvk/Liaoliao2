package cn.huashantech.liaoliao2.test.chapter4;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;

import cn.huashantech.liaoliao2.utils.LogUtil;

/**
 * Created by Dingkang Qin on 2017/10/11.
 * emails: qindingkang@huashantech.cn
 */

public class HorizontalScrollViewEx extends ViewGroup {

    private int mChildrenSize;
    private int mChildWidth;
    private int mChildIndex;

    //记录上次滑动的坐标
    private int mLastX = 0;
    private int mLastY = 0;

    //记录上次滑动的坐标(onInterceptTouchEvent)
    private int mLastXIntercept = 0;
    private int mLastYIntercept = 0;

    private Scroller mScroller;
    //滑动速度追踪
    private VelocityTracker mVelocityTracker;

    public HorizontalScrollViewEx(Context context) {
        super(context);
        init();
    }

    public HorizontalScrollViewEx(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public HorizontalScrollViewEx(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        if (mScroller == null) {
            mScroller = new Scroller(getContext());
            mVelocityTracker = VelocityTracker.obtain();
        }
    }

    //没有考虑到margin和padding
    //在这里把子View横放
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

        int childLeft = 0;
        final int childCount = getChildCount();
        mChildrenSize = childCount;

        for (int i = 0; i < childCount; i++) {
            final View childView = getChildAt(i);
            if (childView.getVisibility() != View.GONE) {
                final int childWidth = childView.getMeasuredWidth();
                mChildWidth = childWidth;
                childView.layout(childLeft, 0, childLeft + childWidth, childView.getMeasuredHeight());
                childLeft += childWidth;
            }
        }

    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean intercepted = false;
        int x = (int) ev.getX();
        int y = (int) ev.getY();
        LogUtil.e("QDK"+"ev.getX= "+x+"  ev.getY= "+y);

        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                LogUtil.e("QDK"+" action_down");
                intercepted = false;
                if (!mScroller.isFinished()) {
                    mScroller.abortAnimation();//停止动画
                    intercepted = true;
                }
                break;
            }
            case MotionEvent.ACTION_MOVE: {
                LogUtil.e("QDK"+" action_move");
                int deltaX = x - mLastXIntercept;
                int deltaY = y - mLastYIntercept;
                intercepted = Math.abs(deltaX) > Math.abs(deltaY);
                break;
            }
            case MotionEvent.ACTION_UP: {
                LogUtil.e("QDK"+" action_up");
                intercepted = false;
                break;
            }
            default:
                break;
        }

        LogUtil.e(intercepted);
        mLastX = x;
        mLastY = y;
        mLastXIntercept = x;
        mLastYIntercept = y;

        return intercepted;
    }

    //拦截了，进行水平滑动
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mVelocityTracker.addMovement(event);
        LogUtil.e("QDK"+"进行水平滑动");
        int x = (int) event.getX();
        int y = (int) event.getY();
        LogUtil.e("QDK"+" 水平滑动 "+"ev.getX= "+x+"  ev.getY= "+y);
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                if (!mScroller.isFinished()) {
                    mScroller.abortAnimation();
                }
                break;
            }
            case MotionEvent.ACTION_MOVE: {
                int deltaX = x - mLastX;
                int deltaY = y - mLastY;
                //滑动了多少然后scrollBy就移动多少
                scrollBy(-deltaX, 0);
                break;
            }
            case MotionEvent.ACTION_UP: {
                LogUtil.e("QDK"+"action_up");
                int scrollX = getScrollX();
                LogUtil.e("QDK"+"scrollX= "+scrollX);
                mVelocityTracker.computeCurrentVelocity(1000);//一秒钟滑动的速度
                float xVelocity = mVelocityTracker.getXVelocity();
                LogUtil.e("QDK"+"滑动速度"+Math.abs(xVelocity));
                if (Math.abs(xVelocity) >= 50) {
                    mChildIndex = xVelocity > 0 ? mChildIndex - 1 : mChildIndex + 1;
                } else {
                    //判断滑动是否过半
                    mChildIndex = (scrollX + mChildWidth / 2) / mChildWidth;
                    LogUtil.e("QDK"+"判断是否滑动过半"+mChildIndex);
                }
                mChildIndex = Math.max(0, Math.min(mChildIndex, mChildrenSize - 1));
                int dx = mChildIndex * mChildWidth - scrollX;
                LogUtil.e("QDK"+"需要滑动的距离 ="+dx);
                smoothScrollBy(dx, 0);
                mVelocityTracker.clear();
                break;
            }
            default:
                break;
        }

        mLastX = x;
        mLastY = y;
        return true;
    }

    private void smoothScrollBy(int dx, int dy) {
        mScroller.startScroll(getScrollX(), 0, dx, 0, 500);
        invalidate();
    }

    @Override
    public void computeScroll() {
        if (mScroller.computeScrollOffset()) {
            scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            postInvalidate();
        }
    }

    //addChild()之后会对每一个子布局进行measure，这里就让布局横着放了
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int measuredWidth;
        int measuredHeight;
        final int childCount = getChildCount();
        measureChildren(widthMeasureSpec, heightMeasureSpec);

        int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);
        int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightSpecSize = MeasureSpec.getSize(heightMeasureSpec);
        int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);

        //没有考虑到margin和padding
        if (childCount == 0) {
            setMeasuredDimension(0, 0);
        } else if (widthSpecMode == MeasureSpec.AT_MOST && heightSpecMode == MeasureSpec.AT_MOST) {
            final View childView = getChildAt(0);
            //这里设定是所有子元素的宽高都是一样的
            //然后这是一个水平滑动的View所以高度就是一个子元素的高度
            measuredWidth = childView.getMeasuredWidth() * childCount;
            measuredHeight = childView.getMeasuredHeight();
            setMeasuredDimension(measuredWidth, measuredHeight);
        } else if (heightSpecMode == MeasureSpec.AT_MOST) {
            final View childView = getChildAt(0);
            measuredHeight = childView.getMeasuredHeight();
            setMeasuredDimension(widthSpecSize, measuredHeight);
        } else if (widthSpecMode == MeasureSpec.AT_MOST) {
            final View childView = getChildAt(0);
            measuredWidth = childView.getMeasuredWidth() * childCount;
            setMeasuredDimension(measuredWidth, heightSpecSize);

        }
    }

    @Override
    protected void onDetachedFromWindow() {
        mVelocityTracker.recycle();
        super.onDetachedFromWindow();
    }
}
