package cn.huashantech.liaoliao2.test.chapter5;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.RemoteViews;

import cn.huashantech.liaoliao2.R;
import cn.huashantech.liaoliao2.view.register.LogInActivity;

/**
 * Created by Dingkang Qin on 2017/10/18.
 * emails: qindingkang@huashantech.cn
 */

public class TestActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_chapter5);
        initNotification();
    }

    private void initNotification(){
        Notification notification=new Notification();
        notification.tickerText="hello world";
        notification.when=System.currentTimeMillis();
        notification.flags=Notification.FLAG_AUTO_CANCEL;
        notification.icon= R.drawable.icon_back;
        Intent intent=new Intent(this, LogInActivity.class);
        RemoteViews remoteViews=new RemoteViews(getPackageName(),R.layout.notification);
        remoteViews.setTextViewText(R.id.notification_text,"chapter_5");
        PendingIntent pendingIntent=PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        remoteViews.setOnClickPendingIntent(R.id.notification_text,pendingIntent);
        notification.contentView=remoteViews;
        notification.contentIntent=pendingIntent;
        NotificationManager manager=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(2,notification);


    }
}
