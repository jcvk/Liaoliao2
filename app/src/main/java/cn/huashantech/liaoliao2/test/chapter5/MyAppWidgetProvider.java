package cn.huashantech.liaoliao2.test.chapter5;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.SystemClock;
import android.widget.RemoteViews;
import android.widget.Toast;

import cn.huashantech.liaoliao2.R;
import cn.huashantech.liaoliao2.utils.LogUtil;

/**
 * Created by Dingkang Qin on 2017/10/18.
 * emails: qindingkang@huashantech.cn
 */

public class MyAppWidgetProvider extends AppWidgetProvider{

    private static final String TAG="chapter5  ";
    private static final String CLICK_ACTION="cn.huashantech.liaoliao2.test.chapter5.action.CLICK";

    public MyAppWidgetProvider(){
        super();
    }

    @Override
    public void onReceive(final Context context, final Intent intent) {
        super.onReceive(context, intent);
        LogUtil.e(TAG+intent.getAction());

        if (intent.getAction().equals(CLICK_ACTION)){
            Toast.makeText(context,"clicked it",Toast.LENGTH_SHORT).show();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    Bitmap srcbBitmap= BitmapFactory.decodeResource(context.getResources(), R.drawable.icon_chapter_5);
                    AppWidgetManager appWidgetManager=AppWidgetManager.getInstance(context);
                    for (int i=0;i<37;i++){
                        float degree=(i*10)%360;
                        RemoteViews remoteViews=new RemoteViews(context.getPackageName(),R.layout.desk_widget);
                        remoteViews.setImageViewBitmap(R.id.desk_image,rotateBitmap(context,srcbBitmap,degree));
                        Intent intentClick=new Intent();
                        intentClick.setAction(CLICK_ACTION);
                        PendingIntent pendingIntent=PendingIntent.getBroadcast(context,0,intentClick,0);
                        remoteViews.setOnClickPendingIntent(R.id.desk_image,pendingIntent);
                        appWidgetManager.updateAppWidget(new ComponentName(context,MyAppWidgetProvider.class),remoteViews);
                        SystemClock.sleep(30);
                    }
                }
            }).start();
        }
    }

    private Bitmap rotateBitmap(Context context,Bitmap srcbBitmap,float degree){
        Matrix matrix=new Matrix();
        matrix.reset();
        matrix.setRotate(degree);
        Bitmap tmpBitmap=Bitmap.createBitmap(srcbBitmap,0,0,srcbBitmap.getWidth(),srcbBitmap.getHeight(),matrix,true);
        return tmpBitmap;
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        final int counter=appWidgetIds.length;
        for (int i=0;i<counter;i++){
            int appWidgetId=appWidgetIds[i];
            onWidgetUpdate(context,appWidgetManager,appWidgetId);
        }
    }

    private void onWidgetUpdate(Context context,AppWidgetManager appWidgetManager,int appWidgetId){
        RemoteViews remoteViews=new RemoteViews(context.getPackageName(),R.layout.desk_widget);
        Intent intentClick=new Intent();
        intentClick.setAction(CLICK_ACTION);
        PendingIntent pendingIntent=PendingIntent.getBroadcast(context,0,intentClick,0);
        remoteViews.setOnClickPendingIntent(R.id.desk_image,pendingIntent);
        appWidgetManager.updateAppWidget(appWidgetId,remoteViews);
    }
}
