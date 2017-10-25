package cn.huashantech.liaoliao2.test.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import cn.huashantech.liaoliao2.LiaoLiaoApplication;

/**
 * Created by Dingkang Qin on 2017/10/23.
 * emails: qindingkang@huashantech.cn
 */

public class NetWorkChangeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager connectivityManager=(ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();
        if (networkInfo!=null&&networkInfo.isAvailable()){
            Toast.makeText(context,"network is available",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context,"network is unavailable",Toast.LENGTH_SHORT).show();
        }

    }
}
