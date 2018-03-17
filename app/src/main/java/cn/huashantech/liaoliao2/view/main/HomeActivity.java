package cn.huashantech.liaoliao2.view.main;

import android.app.IntentService;
import android.content.Context;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.view.View;

import java.util.HashMap;
import java.util.concurrent.ThreadPoolExecutor;

import cn.huashantech.liaoliao2.R;
import cn.huashantech.liaoliao2.base.ActivityPresenter;
import cn.huashantech.liaoliao2.base.BaseContract;
import cn.huashantech.liaoliao2.utils.LogUtil;
import cn.huashantech.liaoliao2.widget.FragmentIndicator;

/**
 * Created by Dingkang Qin on 2017/10/9.
 * emails: qindingkang@huashantech.cn
 */

public class HomeActivity extends ActivityPresenter {

    private FragmentIndicator indicator;

    private static Context sContext;


    @Override
    protected BaseContract.Presenter initPresenter() {
        return null;
    }

    @Override
    protected void initData() {

        sContext=this;


    }

    @Override
    protected void initWidget() {

        indicator=(FragmentIndicator)findViewById(R.id.indicator_main);

        indicator.setOnIndicateListener(new FragmentIndicator.OnIndicateListener() {
            @Override
            public void onIndicate(View v, int which) {
                LogUtil.e("liangliang");
            }
        });

        SystemClock.sleep(7*1000);

    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_home;
    }


}
