package cn.huashantech.liaoliao2.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import cn.huashantech.liaoliao2.R;
import cn.huashantech.liaoliao2.utils.LogUtil;
import cn.huashantech.liaoliao2.utils.ScreenUtils;

/**
 * Created by Dingkang Qin on 2017/12/9.
 * emails: qindingkang@huashantech.cn
 */

public class FragmentIndicator extends LinearLayout implements View.OnClickListener {

    //默认第一个显示的是0
    private int mDefaultIndicator=0;
    //现在的选中的是哪一个布局
    private int currentIndicator;
    //创建4个底部布局
    private LinearLayout[] linearLayouts;
    //图片选中id
    private int[] iconChooseIds={R.drawable.icon_recommend1,R.drawable.icon_friend_news1,
    R.drawable.icon_message1,R.drawable.icon_my_page1};
    //图片未选择id
    private int[] iconNotChooseIds={R.drawable.icon_recommend0,R.drawable.icon_friend_news0,
            R.drawable.icon_message0,R.drawable.icon_my_page0};
    //文字id
    private int[] textIds={R.string.recommend,R.string.friend_news,R.string.messages,R.string.my_page};

    //文字颜色
    private static int colorNotChoose=R.color.colorTextSubContent;
    private static int colorChoose=R.color.colorMain;


    private OnIndicateListener mIndicatorListener;




    public FragmentIndicator(Context context) {
        super(context);
        initView();
    }

    public FragmentIndicator(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public FragmentIndicator(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    @Override
    public void onClick(View v) {

        LogUtil.e("!!!!!!!!!");

        if (mIndicatorListener!=null){

            Integer tag=(Integer)v.getTag();
            LogUtil.e("????????");

            switch (tag){
                case 0:
                    setIndicator(0);
                    mIndicatorListener.onIndicate(v,0);
                    break;
                case 1:
                    setIndicator(1);
                    mIndicatorListener.onIndicate(v,1);
                    break;
                case 2:
                    setIndicator(2);
                    mIndicatorListener.onIndicate(v,2);
                    break;
                case 3:
                    setIndicator(3);
                    mIndicatorListener.onIndicate(v,3);
                    break;
                default:
                    break;
            }
        }
    }


    private void initView(){
        setOrientation(HORIZONTAL);
        linearLayouts=new LinearLayout[4];
        currentIndicator=mDefaultIndicator;

        for (int i=0;i<4;i++){
            linearLayouts[i]=createIndicator(iconNotChooseIds[i],textIds[i]);
            linearLayouts[i].setTag(i);
            addView(linearLayouts[i]);
        }
    }

    private LinearLayout createIndicator(int iconId,int textId){

        //这里一会儿用findView来试一试

        LinearLayout linearLayout=new LinearLayout(getContext());
        linearLayout.setOrientation(VERTICAL);
        linearLayout.setLayoutParams(new LayoutParams(0,ScreenUtils.dp2px(50),1));
        linearLayout.setGravity(Gravity.CENTER_HORIZONTAL);

        //创建图标
        ImageView imageView=new ImageView(getContext());
        imageView.setLayoutParams(new LayoutParams(ScreenUtils.dp2px(25),ScreenUtils.dp2px(25)));
        imageView.setImageResource(iconId);

        //创建文字
        TextView textView=new TextView(getContext());
        textView.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        textView.setText(textId);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP,12);
        textView.setTextColor(getResources().getColor(colorNotChoose));

        linearLayout.addView(imageView);
        linearLayout.addView(textView);

        return linearLayout;

    }

    private void setIndicator(int which){

        if (which!=currentIndicator){

            //当点击下一个布局时，需要把上一个布局的颜色修改回默认值
            LinearLayout preView=linearLayouts[currentIndicator];
            ImageView imageView=(ImageView)preView.getChildAt(0);
            imageView.setImageResource(iconNotChooseIds[currentIndicator]);
            TextView textView=(TextView)preView.getChildAt(1);
            textView.setTextColor(getResources().getColor(colorNotChoose));
            //把现在选择的颜色改为被选中的
            preView=linearLayouts[which];
            imageView=(ImageView)preView.getChildAt(0);
            imageView.setImageResource(iconChooseIds[currentIndicator]);
            textView=(TextView)preView.getChildAt(1);
            textView.setTextColor(getResources().getColor(colorChoose));
            currentIndicator=which;

        }



    }


    public void setOnIndicateListener(OnIndicateListener onIndicateListener){
        mIndicatorListener=onIndicateListener;
    }


    public interface OnIndicateListener{
        void onIndicate(View v,int which);
    }

}
