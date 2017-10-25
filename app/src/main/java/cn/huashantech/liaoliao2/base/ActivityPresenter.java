package cn.huashantech.liaoliao2.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by Dingkang Qin on 2017/9/17.
 * emails: qindingkang@huashantech.cn
 */

public abstract class ActivityPresenter<T extends BaseContract.Presenter> extends BaseActivity
        implements BaseContract.View<BaseContract.Presenter> {

    protected T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        initPresenter();
        super.onCreate(savedInstanceState);
    }

    protected abstract T initPresenter();

    @Override
    public void setPresenter(BaseContract.Presenter presenter) {
        mPresenter= (T) presenter;
    }
}
