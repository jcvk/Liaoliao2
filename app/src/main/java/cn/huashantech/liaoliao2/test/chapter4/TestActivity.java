package cn.huashantech.liaoliao2.test.chapter4;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RemoteViews;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import cn.huashantech.liaoliao2.R;
import cn.huashantech.liaoliao2.utils.LogUtil;
import cn.huashantech.liaoliao2.utils.WindowUtil;
import cn.huashantech.liaoliao2.view.register.LogInActivity;

/**
 * Created by Dingkang Qin on 2017/10/11.
 * emails: qindingkang@huashantech.cn
 */

public class TestActivity extends Activity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        initView();
        initNotification();


    }

    private void initView(){
        LayoutInflater inflater=getLayoutInflater();
        HorizontalScrollViewEx mListContainer = (HorizontalScrollViewEx) findViewById(R.id.container);
        final int screenWidth= WindowUtil.getScreenMetrics(this).widthPixels;
        final int screenHeight=WindowUtil.getScreenMetrics(this).heightPixels;
        LogUtil.e("QDK"+"屏幕的宽度和高度"+screenWidth+"   "+screenHeight);

        for (int i=0;i<3;i++){
            //如果为false，并且mListContainer不为空，那么会将mListContainer的LayoutParams传个layout
            ViewGroup layout=(ViewGroup)inflater.inflate(R.layout.content_layout, mListContainer,false);
            //layout是一个和屏幕一样宽的一个布局
            layout.getLayoutParams().width=screenWidth;
            TextView textView=(TextView)layout.findViewById(R.id.contain_title);
            textView.setText("页面"+i);
            layout.setBackgroundColor(Color.rgb(225/(i+1),225/(i+1),0));
            createList(layout);
            mListContainer.addView(layout);

        }
    }

    private void createList(ViewGroup layout){
        ListView listView=(ListView)layout.findViewById(R.id.contain_list);
        ArrayList<String> data=new ArrayList<>();
        for (int i=0;i<200;i++){
            data.add("name "+i);
        }

        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,R.layout.content_list_item,R.id.contain_list_item,data);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(TestActivity.this,"click item"+position,Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void initNotification(){
        Notification notification=new Notification();
        notification.tickerText="hello world";
        notification.when=System.currentTimeMillis();
        notification.flags=Notification.FLAG_AUTO_CANCEL;
        notification.icon=R.drawable.icon_back;
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
