package cn.huashantech.liaoliao2.test.chapter4;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import cn.huashantech.liaoliao2.R;
import cn.huashantech.liaoliao2.utils.LogUtil;

/**
 * Created by Dingkang Qin on 2017/10/14.
 * emails: qindingkang@huashantech.cn
 */

public class CircleView extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private int mColor;

    public CircleView(Context context) {
        super(context);
        init();
    }

    public CircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        //首先加载自定义属性集合CircleView
        TypedArray typedArray=context.obtainStyledAttributes(attrs, R.styleable.CircleView);
        //解析属性集合中的circle_color属性
        //如果这个属性没有设置，那么就为默认的红色，否则就用CircleView_circle_color
        mColor=typedArray.getColor(R.styleable.CircleView_circle_color,Color.GREEN);
        typedArray.recycle();
        init();
    }

    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
//        int mColor = Color.RED;
        mPaint.setColor(mColor);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        final int paddingLeft = getPaddingLeft();
        final int paddingRight = getPaddingRight();
        final int paddingTop = getPaddingTop();
        final int paddingBottom = getPaddingBottom();
        int width = getWidth() - paddingLeft - paddingRight;
        int height = getHeight() - paddingTop - paddingBottom;
        int radius = Math.min(width, height) / 2;
        //选择圆点，然后选择半径
        canvas.drawCircle(getPaddingLeft() + width / 2, getPaddingTop() + height / 2, radius, mPaint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //获取宽度的属性，看宽度是否为wrap_content，或者match_parent，或者自定义的长度
        int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        //不管什么属性都会有长度，获取宽度的长度
        int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSpecSize = MeasureSpec.getSize(heightMeasureSpec);
        int mWidth = 200;
        int mHeight = 200;
        //判断长宽的属性，如果是wrap_content，那么就将设置为默认的长度
        //否则还是用之前的长度
        if (widthSpecMode == MeasureSpec.AT_MOST && heightSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(mWidth, mHeight);
        } else if (widthSpecMode == MeasureSpec.AT_MOST) {
            LogUtil.e("fuck you");
            setMeasuredDimension(mWidth, heightSpecSize);
        } else if (heightSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(widthSpecSize, mHeight);
        }
    }
}
