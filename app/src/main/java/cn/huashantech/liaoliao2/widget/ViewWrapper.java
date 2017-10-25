package cn.huashantech.liaoliao2.widget;

import android.view.View;

import cn.huashantech.liaoliao2.utils.LogUtil;

/**
 * Created by Dingkang Qin on 2017/10/22.
 * emails: qindingkang@huashantech.cn
 */

public class ViewWrapper {

    private View mTarget;

    public ViewWrapper(View mTarget) {
        this.mTarget = mTarget;
    }

    public int getWidth(){
        return mTarget.getLayoutParams().width;
    }

    public void setWidth(int width){
        mTarget.getLayoutParams().width=width;
        mTarget.requestLayout();
    }
}
