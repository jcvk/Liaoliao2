package cn.huashantech.liaoliao2.network;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Dingkang Qin on 2017/9/23.
 * emails: qindingkang@huashantech.cn
 */

public abstract class NetCallBack<T> implements Callback<T> {
    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        ResponseError.dealError(response.code());
        if (response.code()==200){
            onSuccess(response);
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {

    }

    public abstract void onSuccess(Response<T> response);
}
