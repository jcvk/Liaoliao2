package cn.huashantech.liaoliao2.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import java.util.UUID;

import cn.huashantech.liaoliao2.LiaoLiaoApplication;

/**
 * Created by Dingkang Qin on 2017/9/20.
 * emails: qindingkang@huashantech.cn
 */

public class DeviceInfoUtil {

    public static String getUserAgent(){
        StringBuilder userAgent=new StringBuilder();
        String versionName=getVersionName();
        //屏幕分辨率
        WindowManager manager=(WindowManager)LiaoLiaoApplication.getInstance().getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm=new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(dm);
        int mScreenWidth=dm.widthPixels;
        int mScreenHeight=dm.heightPixels;
        userAgent.append("huashanTech-liaoliao-aocp;");
        userAgent.append(versionName).append(";");
        userAgent.append(Build.BRAND).append(";");
        userAgent.append(Build.MODEL).append(";");
        userAgent.append("Android").append(Build.VERSION.RELEASE).append(";");
        userAgent.append(mScreenWidth).append("*").append(mScreenHeight);
        return userAgent.toString();

    }

    public static String getUUID(){
        TelephonyManager tm=(TelephonyManager)LiaoLiaoApplication.getInstance().getSystemService(Context.TELEPHONY_SERVICE);

        String tmDevice=tm.getDeviceId();
        String tmSerial=tm.getSimSerialNumber();
        String androidId=android.provider.Settings.Secure.getString(LiaoLiaoApplication.getInstance().getContentResolver(), android.provider.Settings.Secure.ANDROID_ID);

        UUID deviceUuid=new UUID(androidId.hashCode(),((long) tmDevice.hashCode() << 32) | tmSerial.hashCode());

        String uniqueId=deviceUuid.toString();
        return uniqueId;


    }

    private static String getVersionName(){
        String pkName=LiaoLiaoApplication.getInstance().getPackageName();
        String versionName="";
        try {
            versionName= LiaoLiaoApplication.getInstance().getPackageManager().getPackageInfo(pkName,0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionName;
    }
}
