package cn.huashantech.liaoliao2.test.ipc;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

import cn.huashantech.liaoliao2.utils.LogUtil;

/**
 * Created by Dingkang Qin on 2018/3/16.
 * emails: qindingkang@huashantech.cn
 */

public class MyIntentService extends IntentService {


    public static final String TAG="MyIntentService";
    public static final String ACTION_DOWN_IMG="down.image";
    public static final String ACTION_DOWN_VID="down.vid";


    public MyIntentService() {
        super(TAG);
        setIntentRedelivery(true);
    }



    @Override
    public void onCreate() {
        super.onCreate();
        LogUtil.e(TAG,"onCreate");
    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        LogUtil.e(TAG,"onStartCommand");
        return super.onStartCommand(intent, flags, startId);

    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        LogUtil.e(TAG,"onHandleIntent thread: "+Thread.currentThread().getId());
        String action=intent.getAction();
        if (action.endsWith(ACTION_DOWN_IMG)){
            for (int i = 0; i <100 ; i++) {
                try {
                    LogUtil.e(TAG,i);
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }else if (action.endsWith(ACTION_DOWN_VID)){
            for (int i = 0; i <100 ; i++) {
                try {
                    Thread.sleep(70);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }

        LogUtil.e(TAG,"onHandleIntent end");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtil.e(TAG,"onDestroy");
    }
}
