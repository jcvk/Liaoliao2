package cn.huashantech.liaoliao2.test.chapter7;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import cn.huashantech.liaoliao2.R;
import cn.huashantech.liaoliao2.widget.ViewWrapper;

/**
 * Created by Dingkang Qin on 2017/10/22.
 * emails: qindingkang@huashantech.cn
 */

public class TestActivity extends Activity{

    private Button button;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_chapter7);
        initView();
    }

    private void initView(){
        button=(Button)findViewById(R.id.chapter7_button);
//        Animation animation= AnimationUtils.loadAnimation(this,R.anim.anim_chapter7);
//        button.startAnimation(animation);
//        button.requestLayout();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performAnimate();
            }
        });

    }

    private void performAnimate(){
        ViewWrapper viewWrapper=new ViewWrapper(button);
        ObjectAnimator.ofInt(viewWrapper,"width",500).setDuration(5000).start();
    }

}
