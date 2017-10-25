package cn.huashantech.liaoliao2.model.register;

import cn.huashantech.liaoliao2.entity.dto.LoginRequestDTO;
import cn.huashantech.liaoliao2.network.NetCallBack;
import cn.huashantech.liaoliao2.network.RestClient;
import cn.huashantech.liaoliao2.network.Result;
import cn.huashantech.liaoliao2.presenter.register.LogInPresenter;
import retrofit2.Response;

/**
 * Created by Dingkang Qin on 2017/9/23.
 * emails: qindingkang@huashantech.cn
 */

public class ModelHelper {

    public static void requestLogInDTO(LoginRequestDTO loginRequestDTO, final LogInPresenter logInPresenter){
        RestClient.getApiService().login(loginRequestDTO).enqueue(new NetCallBack<Result<LoginDTO>>() {
            @Override
            public void onSuccess(Response<Result<LoginDTO>> response) {
                Result<LoginDTO> result=response.body();
                LoginDTO loginDTO=result.getRes();
                logInPresenter.getLogInDTOSuccess(loginDTO);
            }
        });
    }

    public static void requestVerificationCode(String phoneNumber,final LogInPresenter logInPresenter){
        RestClient.getApiService().getVerificationCode(phoneNumber).enqueue(new NetCallBack<Result>() {
            @Override
            public void onSuccess(Response<Result> response) {
                logInPresenter.getVerificationCodeSuccess();
            }
        });

    }
}
