package cn.huashantech.liaoliao2.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ProgressBar;

import cn.huashantech.liaoliao2.R;
import cn.huashantech.liaoliao2.utils.ScreenUtils;

/**
 * Created by Dingkang Qin on 2017/12/13.
 * emails: qindingkang@huashantech.cn
 */

public class HorizontalProgressBar extends ProgressBar {

    private static final int TEXT_COLOR_DEFAULT=0xffffff;
    private static final int TEXT_SIZE_DEFAULT=10;
    private static final int PROGRESS_REACH_COLOR=0xff00ff;
    private static final int PROGRESS_REACH_HEIGHT=10;
    private static final int PROGRESS_UNREACH_COLOR=0xff00ff;
    private static final int PROGRESS_UNREACH_HEIGHT=10;
    private static final int TEXT_OFFSET_DEFAULT=10;

    private int textColor=TEXT_COLOR_DEFAULT;
    private int textSize= ScreenUtils.sp2px(TEXT_SIZE_DEFAULT);
    private int progressUnreachColor=PROGRESS_UNREACH_COLOR;
    private int progressUnreachHeight =ScreenUtils.dp2px(PROGRESS_UNREACH_HEIGHT);
    private int progressReachColor=PROGRESS_REACH_COLOR;
    private int progressReachHeight =ScreenUtils.dp2px(PROGRESS_REACH_HEIGHT);
    private int textOffset=ScreenUtils.dp2px(TEXT_OFFSET_DEFAULT);





    public HorizontalProgressBar(Context context) {
        super(context,null,0);
    }

    public HorizontalProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs,0);
    }

    public HorizontalProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        getAttrs(attrs);


    }

    private void getAttrs(AttributeSet attrs){

        TypedArray ta=getContext().obtainStyledAttributes(attrs, R.styleable.HorizontalProgressBar);
        textColor=ta.getColor(R.styleable.HorizontalProgressBar_progress_text_color,textColor);
        textSize= (int) ta.getDimension(R.styleable.HorizontalProgressBar_progress_text_size,textSize);
        textOffset= (int) ta.getDimension(R.styleable.HorizontalProgressBar_progress_text_offset,textOffset);
        progressReachColor=ta.getColor(R.styleable.HorizontalProgressBar_progress_reach_color,progressReachColor);
        progressUnreachColor=ta.getColor(R.styleable.HorizontalProgressBar_progress_unreach_color,progressUnreachColor);
        progressReachHeight = (int) ta.getDimension(R.styleable.HorizontalProgressBar_progress_reach_height, progressReachHeight);
        progressUnreachHeight=(int) ta.getDimension(R.styleable.HorizontalProgressBar_progress_unreach_height,progressUnreachHeight);
        ta.recycle();

    }
}
