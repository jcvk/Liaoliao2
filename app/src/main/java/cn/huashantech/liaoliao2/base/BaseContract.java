package cn.huashantech.liaoliao2.base;

/**
 * Created by Dingkang Qin on 2017/9/17.
 * emails: qindingkang@huashantech.cn
 */

public interface BaseContract {

    interface View<T extends Presenter>{

        //绑定一个Presenter
        void setPresenter(T presenter);
    }

    interface Presenter{

        //初始化方法
        void start();

        //销毁
        void destroy();
    }

}
