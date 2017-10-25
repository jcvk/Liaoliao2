package cn.huashantech.liaoliao2.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Dingkang Qin on 2017/9/17.
 * emails: qindingkang@huashantech.cn
 */

public class CountDownButton extends android.support.v7.widget.AppCompatButton implements View.OnClickListener {

    /*默认倒计时长*/
    private long countDownLength = 60 * 1000;

    /*未点击之前的显示的文字*/
    private String beforeText = "获取验证码";

    /*倒计时结束后获取*/
    private String refreshText = "重新获取";
    /**
     * 开始执行计时的类，可以在每秒实行间隔任务
     */
    private Timer timer;
    /**
     * 在开始倒计时之后那个秒数数字之后所要显示的字，默认是秒
     */
    private String afterText = "秒";
    /**
     * 按钮点击事件
     */
    private OnClickListener onClickListener;

    /**
     * 每秒时间到了之后所执行的任务
     */
    private TimerTask timerTask;

    public CountDownButton(Context context) {
        super(context);
        init();
    }

    public CountDownButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CountDownButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }



    private void init(){
        this.setText(beforeText);
        this.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        start();
        if (onClickListener!=null){
            onClickListener.onClick(v);
        }
    }

    @Override
    public void setOnClickListener(@Nullable OnClickListener l) {
        if (l instanceof CountDownButton){
            super.setOnClickListener(l);
        }else {
            this.onClickListener=l;
        }
    }

    /**
     * 开始倒计时
     */
    public void start(){
        initTimer();
        this.setText(countDownLength/1000+afterText);
        this.setEnabled(false);
        timer.schedule(timerTask,0,1000);
    }

    /**
     * 初始化时间
     */
    private void initTimer(){
        timer=new Timer();
        timerTask=new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0);
            }
        };
    }

    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    CountDownButton.this.setText(countDownLength/1000+afterText);
                    countDownLength-=1000;
                    if (countDownLength<0){
                        CountDownButton.this.setEnabled(true);
                        CountDownButton.this.setText(refreshText);
                        clearTimer();
                        countDownLength=60*1000;
                    }
                    break;
                default:
                    break;
            }
        }
    };

    private void clearTimer(){
        if (timerTask!=null){
            timerTask.cancel();
            timerTask=null;
        }
        if (timer!=null){
            timer.cancel();
            timer=null;
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        clearTimer();
        super.onDetachedFromWindow();
    }
}
