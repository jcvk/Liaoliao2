package cn.huashantech.liaoliao2;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import cn.huashantech.liaoliao2.utils.CacheUtil;
import cn.huashantech.liaoliao2.utils.LogUtil;

/**
 * Created by Dingkang Qin on 2017/9/20.
 * emails: qindingkang@huashantech.cn
 */

public class LiaoLiaoApplication extends Application{

    private static LiaoLiaoApplication instance;
    private static List<Activity> activityList=new ArrayList<>();
    private CacheUtil cacheUtil;
    private static int count=0;

    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
        registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    public static LiaoLiaoApplication getInstance(){
        return instance;
    }

    public CacheUtil getCacheUtil(){
        if (cacheUtil==null){
            cacheUtil=CacheUtil.get(instance.getCacheDir());
        }
        return cacheUtil;
    }



    private static ActivityLifecycleCallbacks activityLifecycleCallbacks=new ActivityLifecycleCallbacks() {
        @Override
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            activityList.add(activity);
            LogUtil.e(activity.getLocalClassName(),"ActivityCreated");
        }

        @Override
        public void onActivityStarted(Activity activity) {
            count++;
            LogUtil.e(activity.getLocalClassName(),"ActivityStarted");
        }

        @Override
        public void onActivityResumed(Activity activity) {
            LogUtil.e(activity.getLocalClassName(),"ActivityResumed");
        }

        @Override
        public void onActivityPaused(Activity activity) {
            LogUtil.e(activity.getLocalClassName(),"ActivityPaused");
        }

        @Override
        public void onActivityStopped(Activity activity) {
            count--;
            LogUtil.e(activity.getLocalClassName(),"ActivityStopped");
        }

        @Override
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

        }

        @Override
        public void onActivityDestroyed(Activity activity) {

        }
    };

    /**
     * 移除Activity
     * @param activity
     */
    public static void removeActivity(Activity activity){
        if (activity!=null&&!activity.isFinishing()){
            activity.finish();
        }
    }

    /**
     * 移除所有Activity
     */
    public static void removeAllActivity(){
        for (Activity activity:activityList){
            removeActivity(activity);
        }
    }

    /**
     * 退出App
     */
    public void exitApp(){
        removeAllActivity();
    }


}
