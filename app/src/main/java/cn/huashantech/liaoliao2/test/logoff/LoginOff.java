package cn.huashantech.liaoliao2.test.logoff;

import android.content.Intent;

import cn.huashantech.liaoliao2.LiaoLiaoApplication;
import cn.huashantech.liaoliao2.view.register.LogInActivity;

/**
 * Created by Dingkang Qin on 2017/10/25.
 * emails: qindingkang@huashantech.cn
 */

public class LoginOff {


    public static void forceOff(){


//      发送服务
        Intent intent=new Intent("cn.huashantech.liaoliao2.FORCE_OFFLINE");
        LiaoLiaoApplication.getInstance().sendBroadcast(intent);
//        Intent intent=new Intent(LiaoLiaoApplication.getInstance(), LogInActivity.class);
//        LiaoLiaoApplication.getInstance().startActivity(intent);
    }
}
