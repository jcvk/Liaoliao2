package cn.huashantech.liaoliao2.utils;

import android.os.Handler;
import android.os.Looper;

/**
 * Created by Dingkang Qin on 2017/9/29.
 * emails: qindingkang@huashantech.cn
 */

public class ThreadUtil {

    private static Handler uiHandle;

    private static void getUIHandle(){
        if (uiHandle==null){
            synchronized (ThreadUtil.class){
                if(uiHandle==null){
                    uiHandle=new Handler(Looper.getMainLooper());
                }
            }
        }
    }

    public static void runOnUiThread(Runnable runnable){
        runOnUiThread(runnable,0);
    }

    public static void runOnUiThread(Runnable runnable,long delayMills){
        getUIHandle();
        uiHandle.postDelayed(runnable,delayMills);
    }

    public static void runOnNewThread(Runnable runnable){
        new Thread(runnable).start();
    }
}
