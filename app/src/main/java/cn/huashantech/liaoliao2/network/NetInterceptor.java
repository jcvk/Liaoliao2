package cn.huashantech.liaoliao2.network;

import java.io.IOException;

import cn.huashantech.liaoliao2.LiaoLiaoApplication;
import cn.huashantech.liaoliao2.config.CacheConfig;
import cn.huashantech.liaoliao2.config.NetConfig;
import cn.huashantech.liaoliao2.utils.CacheUtil;
import cn.huashantech.liaoliao2.utils.DeviceInfoUtil;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Dingkang Qin on 2017/9/20.
 * emails: qindingkang@huashantech.cn
 */

public class NetInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Request realRequest;
        String urlPath = request.url().encodedPath();
        if (!urlPath.startsWith(NetConfig.VERIFICATION_URL) && !urlPath.startsWith(NetConfig.LOGIN_URL)) {
            CacheUtil cacheUtil = LiaoLiaoApplication.getInstance().getCacheUtil();
            String accessToken = cacheUtil.getString(CacheConfig.ACCESS_TOKEN);
            String UID = String.valueOf(cacheUtil.getUserHomePageVo().getSysUserPO().getId());
            realRequest = request.newBuilder()
                    .addHeader("token", accessToken)
                    .addHeader("UID", UID)
                    .addHeader("DID", DeviceInfoUtil.getUUID())
                    .addHeader("User-Agent", DeviceInfoUtil.getUserAgent())
                    .build();

        } else {
            realRequest = request.newBuilder()
                    .addHeader("DID", DeviceInfoUtil.getUUID())
                    .addHeader("User-Agent", DeviceInfoUtil.getUserAgent())
                    .build();
        }
        Response response = chain.proceed(realRequest);
        return response;
    }
}
