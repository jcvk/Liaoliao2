package cn.huashantech.liaoliao2.test.ipc;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by Dingkang Qin on 2018/3/17.
 * emails: qindingkang@huashantech.cn
 */

public class BinderPoolService extends Service {

    private static final String TAG="BinderPoolService";

    private Binder mBinderPool = new BinderPool.BinderPoolImpl();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinderPool;
    }
}
