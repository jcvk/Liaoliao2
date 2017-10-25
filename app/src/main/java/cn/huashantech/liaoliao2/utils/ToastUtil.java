package cn.huashantech.liaoliao2.utils;

import android.support.annotation.StringRes;
import android.widget.Toast;

/**
 * Created by Dingkang Qin on 2017/9/29.
 * emails: qindingkang@huashantech.cn
 */

public class ToastUtil {
    private static final int duration= Toast.LENGTH_SHORT;

    public static void showToast(@StringRes final int resId){
        ThreadUtil.runOnUiThread(new Runnable() {
            @Override
            public void run() {

            }
        });
    }

}
