package cn.huashantech.liaoliao2.network;

import cn.huashantech.liaoliao2.model.register.LoginDTO;
import cn.huashantech.liaoliao2.entity.dto.LoginRequestDTO;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Dingkang Qin on 2017/9/20.
 * emails: qindingkang@huashantech.cn
 */

public interface APIService {

    @POST("api/v1.0/login")
    Call<Result<LoginDTO>>login(@Body LoginRequestDTO loginRequestDTO);

    @GET("api/v1.0/getVerificationCode")
    Call<Result>getVerificationCode(@Query("phoneNumber")String phoneNumber);


}
