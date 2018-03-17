package cn.huashantech.liaoliao2.test.ipc;

import android.app.Activity;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

import cn.huashantech.liaoliao2.aidl.ICompute;
import cn.huashantech.liaoliao2.test.ipc.implement.ComputeImpl;
import cn.huashantech.liaoliao2.utils.LogUtil;


/**
 * Created by Dingkang Qin on 2018/3/16.
 * emails: qindingkang@huashantech.cn
 */

public class SecondActivity extends Activity {

    public static final String TAG="SecondActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    doWork();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    private void doWork() throws InterruptedException {
        BinderPool binderPool=BinderPool.getInstance(SecondActivity.this);
        //获取计算的服务
        IBinder computeBinder=binderPool.queryBinder(BinderPool.BINDER_SECURITY_CENTER);
        ICompute mCompute= ComputeImpl.asInterface(computeBinder);
        LogUtil.e(TAG,"gg");
        try {
            LogUtil.e("second activity","3+5"+mCompute.add(3,5));
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }
}
