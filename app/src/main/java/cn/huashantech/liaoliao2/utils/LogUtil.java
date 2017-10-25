package cn.huashantech.liaoliao2.utils;

import android.util.Log;

/**
 * Created by Dingkang Qin on 2017/9/20.
 * emails: qindingkang@huashantech.cn
 */

public class LogUtil {

    private static String TAG="Liaoliao";
    private static boolean DEBUG=true;

    /**
     * 如果不需要打印日志，把debug设置为false
     * @param msg
     */
    public static void e(Object msg){
        if (DEBUG){
            Log.e(TAG,msg.toString());
        }
    }

    public static void e(String tag,Object msg){
        if (DEBUG){
            Log.e(tag,msg.toString());
        }
    }
}
