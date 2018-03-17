package cn.huashantech.liaoliao2.test.ipc;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;

import java.util.concurrent.CountDownLatch;

import cn.huashantech.liaoliao2.aidl.IBinderPool;
import cn.huashantech.liaoliao2.test.ipc.implement.ComputeImpl;
import cn.huashantech.liaoliao2.test.ipc.implement.IBookManagerImpl;
import cn.huashantech.liaoliao2.utils.LogUtil;

/**
 * Created by Dingkang Qin on 2018/3/17.
 * emails: qindingkang@huashantech.cn
 */

public class BinderPool {

    private static final String TAG = "BinderPool";

    public static final int BINDER_NOTE = 1;
    public static final int BINDER_COMPUTE = 0;
    public static final int BINDER_SECURITY_CENTER = 1;
    private static volatile BinderPool sInstance;

    private Context mContext;
    private IBinderPool mBinderPool;

    private CountDownLatch mConnectBinderPoolCountDownLatch;

    private BinderPool(Context context) throws InterruptedException {
        mContext = context.getApplicationContext();
        connectBinderPoolService();

    }


    public static BinderPool getInstance(Context context) throws InterruptedException {

        synchronized (BinderPool.class) {
            if (sInstance == null) {
                return new BinderPool(context);
            }
            return sInstance;
        }
    }

    private synchronized void connectBinderPoolService() throws InterruptedException {
        mConnectBinderPoolCountDownLatch = new CountDownLatch(1);
        Intent service = new Intent(mContext, BinderPoolService.class);
        mContext.bindService(service, mBinderPoolConnection, Context.BIND_AUTO_CREATE);
        mConnectBinderPoolCountDownLatch.await();//这里会等待其他的线程执行
    }

    public IBinder queryBinder(int binderCode) {
        IBinder binder = null;

        try {
            if (mBinderPool != null) {
                binder = mBinderPool.queryBinder(binderCode);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        return binder;
    }

    private ServiceConnection mBinderPoolConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mBinderPool = IBinderPool.Stub.asInterface(service);

            try {
                mBinderPool.asBinder().linkToDeath(mBinderPoolDeathRecipient, 0);
            } catch (RemoteException e) {
                e.printStackTrace();
            }

            mConnectBinderPoolCountDownLatch.countDown();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    private IBinder.DeathRecipient mBinderPoolDeathRecipient = new IBinder.DeathRecipient() {
        @Override
        public void binderDied() {
            LogUtil.e(TAG, "binder died");
            mBinderPool.asBinder().unlinkToDeath(mBinderPoolDeathRecipient, 0);
            mBinderPool = null;
            //重连
            try {
                connectBinderPoolService();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    /**
     * 这个按照之前的写法是放在Service中实现的。
     */
    public static class BinderPoolImpl extends IBinderPool.Stub {


        public BinderPoolImpl() {
            super();
        }

        @Override
        public IBinder queryBinder(int binderCode) throws RemoteException {
            IBinder binder = null;
            switch (binderCode) {
                case BINDER_COMPUTE: {
                    binder = new IBookManagerImpl();
                    break;
                }
                case BINDER_SECURITY_CENTER: {
                    binder = new ComputeImpl();
                }
                default:
                    break;
            }
            return binder;
        }
    }
}
