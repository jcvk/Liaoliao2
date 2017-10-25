package cn.huashantech.liaoliao2.test.chapter6;

import android.app.Activity;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import cn.huashantech.liaoliao2.R;

/**
 * Created by Dingkang Qin on 2017/10/21.
 * emails: qindingkang@huashantech.cn
 */

public class TestActivity extends Activity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_chapter6);
        TextView textView=(TextView)findViewById(R.id.chapter6_text);
        ClipDrawable scaleDrawable=(ClipDrawable)textView.getBackground();
        scaleDrawable.setLevel(5000);
    }
}
