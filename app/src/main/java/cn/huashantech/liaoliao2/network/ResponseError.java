package cn.huashantech.liaoliao2.network;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;

import cn.huashantech.liaoliao2.LiaoLiaoApplication;

/**
 * Created by Dingkang Qin on 2017/9/23.
 * emails: qindingkang@huashantech.cn
 */

public class ResponseError {

    public static void dealError(int code){

        switch (code){
            case 401:
                errorFor401();
                break;
            default:
                break;

        }

    }

    private static void errorFor401(){
        // TODO: 2017/9/23
    }

}
