package cn.huashantech.liaoliao2.test.ipc;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.support.annotation.Nullable;

import cn.huashantech.liaoliao2.utils.LogUtil;

/**
 * Created by Dingkang Qin on 2018/3/16.
 * emails: qindingkang@huashantech.cn
 */

public class MessageService extends Service {

    public static final String TAG="MessageService";

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mMessenger.getBinder();
    }

    private static class MessengerHandler extends Handler{
        @Override
        public void handleMessage(Message msg) {

            switch (msg.what){
                case 1:
                    LogUtil.e(TAG,"receive msg from Client"+msg.getData().getString("msg"));
                    break;
                default:
                    super.handleMessage(msg);

            }
        }
    }

    private final Messenger mMessenger = new Messenger(new MessengerHandler());


}
