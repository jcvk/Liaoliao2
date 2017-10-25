package cn.huashantech.liaoliao2.base;

/**
 * Created by Dingkang Qin on 2017/9/17.
 * emails: qindingkang@huashantech.cn
 */

public class BasePresenter<T extends BaseContract.View> implements BaseContract.Presenter {

    protected T mView;

    /**
     * p层构造方法
     * 创建p层时就进行双向绑定
     * @param mView v层的引用
     */
    @SuppressWarnings("unchecked")
    public BasePresenter(T mView) {
        this.mView = mView;
        this.mView.setPresenter(this);
    }

    @Override
    public void start() {


    }

    /**
     * 销毁p层，销毁v与p之间的引用,避免内存泄漏
     */
    @SuppressWarnings("unchecked")
    @Override
    public void destroy() {

        T view=mView;
        mView=null;
        if (view!=null){
            view.setPresenter(null);
        }
    }
}
