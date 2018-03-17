package cn.huashantech.liaoliao2.test.provider;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import cn.huashantech.liaoliao2.R;

/**
 * Created by Dingkang Qin on 2018/3/17.
 * emails: qindingkang@huashantech.cn
 */

public class ProviderActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provider_main);
        Button button=(Button)findViewById(R.id.btn_provider_test1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri=Uri.parse("content://cn.huashantech.liaoliao2.test.provider");
                getContentResolver().query(uri,null,null,null,null);
            }
        });
    }
}
