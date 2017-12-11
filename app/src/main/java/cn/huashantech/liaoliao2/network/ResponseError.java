package cn.huashantech.liaoliao2.network;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;

import cn.huashantech.liaoliao2.LiaoLiaoApplication;
import cn.huashantech.liaoliao2.config.CacheConfig;
import cn.huashantech.liaoliao2.entity.vo.RefreshTokenVO;
import cn.huashantech.liaoliao2.entity.vo.UserHomePageVO;
import cn.huashantech.liaoliao2.model.register.LoginDTO;
import cn.huashantech.liaoliao2.utils.CacheUtil;
import retrofit2.Response;

/**
 * Created by Dingkang Qin on 2017/9/23.
 * emails: qindingkang@huashantech.cn
 */

public class ResponseError {

    public static void dealError(int code) {

        switch (code) {
            case 401:
                errorFor401();
                break;
            default:
                break;

        }

    }

    //每一个用户初始化融云连接时都需要一个token
    //返回401表示token失效，需要重新获取
    private static void errorFor401() {
        String refreshToken = LiaoLiaoApplication.getInstance().getCacheUtil().getString(CacheConfig.REFRESH_TOKEN);
        long userId = LiaoLiaoApplication.getInstance().getCacheUtil().getUserHomePageVo().getSysUserPO().getId();
        RefreshTokenVO refreshTokenVO = new RefreshTokenVO();
        refreshTokenVO.setRefreshToken(refreshToken);
        refreshTokenVO.setUserId(userId);
        RestClient.getApiService().refreshToken(refreshTokenVO).enqueue(new NetCallBack<Result<LoginDTO>>() {
            @Override
            public void onSuccess(Response<Result<LoginDTO>> response) {
                Result result = response.body();
                LoginDTO loginDTO = (LoginDTO) result.getRes();
                String accessToken = loginDTO.getAccessToken();
                String refreshToken = loginDTO.getRefreshToken();
                UserHomePageVO userHomePageVO = loginDTO.getHomePageVO();
                CacheUtil cacheUtil = LiaoLiaoApplication.getInstance().getCacheUtil();
                cacheUtil.putSerializableObj(CacheConfig.USER_KEY, userHomePageVO);
                cacheUtil.putString(CacheConfig.ACCESS_TOKEN, accessToken);
                cacheUtil.putString(CacheConfig.REFRESH_TOKEN, refreshToken);
            }
        });
    }

}
