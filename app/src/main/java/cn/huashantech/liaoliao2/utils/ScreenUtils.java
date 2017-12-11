package cn.huashantech.liaoliao2.utils;


import cn.huashantech.liaoliao2.LiaoLiaoApplication;

/**
 * Created by Dingkang Qin on 2017/12/9.
 * emails: qindingkang@huashantech.cn
 */

public class ScreenUtils {


    public static int px2dip(float pxValue) {
        final float scale = LiaoLiaoApplication.getInstance().getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    public static int dp2px(float dpValue) {
        final float scale = LiaoLiaoApplication.getInstance().getResources().getDisplayMetrics().density;
        LogUtil.e("screenWidth "+screenWidth());
        return (int) (dpValue * scale + 0.5f);
    }

    public static int screenWidth(){
        return LiaoLiaoApplication.getInstance().getResources().getDisplayMetrics().widthPixels;
    }
}
