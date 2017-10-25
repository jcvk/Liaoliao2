package cn.huashantech.liaoliao2.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * Created by Dingkang Qin on 2017/10/16.
 * emails: qindingkang@huashantech.cn
 */

public class WindowUtil {

    public static DisplayMetrics getScreenMetrics(Context context){
        WindowManager wm=(WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm=new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        return dm;
    }
}
