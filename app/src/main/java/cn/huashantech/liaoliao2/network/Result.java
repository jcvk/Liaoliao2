package cn.huashantech.liaoliao2.network;

import java.io.Serializable;

/**
 * Created by Dingkang Qin on 2017/9/23.
 * emails: qindingkang@huashantech.cn
 */

public class Result<T> implements Serializable {

    private T res;


    public T getRes() {
        return res;
    }

    public void setRes(T res) {
        this.res = res;
    }
}
