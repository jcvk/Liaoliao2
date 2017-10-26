package cn.huashantech.liaoliao2.test.logoff;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import cn.huashantech.liaoliao2.LiaoLiaoApplication;
import cn.huashantech.liaoliao2.utils.LogUtil;
import cn.huashantech.liaoliao2.view.register.LogInActivity;

/**
 * Created by Dingkang Qin on 2017/10/25.
 * emails: qindingkang@huashantech.cn
 */

public class ForceOfflineReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        LiaoLiaoApplication.removeAllActivity();
        Intent intent1=new Intent(context, LogInActivity.class);
        context.startActivity(intent1);
    }
}
