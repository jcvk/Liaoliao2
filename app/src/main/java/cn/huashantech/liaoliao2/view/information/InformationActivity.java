package cn.huashantech.liaoliao2.view.information;

import android.view.View;
import android.view.ViewGroup;

import cn.huashantech.liaoliao2.base.ActivityPresenter;
import cn.huashantech.liaoliao2.base.BaseContract;

/**
 * Created by Dingkang Qin on 2017/10/9.
 * emails: qindingkang@huashantech.cn
 */

public class InformationActivity extends ActivityPresenter {
    @Override
    protected BaseContract.Presenter initPresenter() {
        return null;
    }

    @Override
    protected void initData() {
        View viewGroup= ((ViewGroup)getWindow().getDecorView().findViewById(android.R.id.content)).getChildAt(0);

    }

    @Override
    protected void initWidget() {

    }

    @Override
    protected int getContentLayoutId() {
        return 0;
    }
}
