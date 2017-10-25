package cn.huashantech.liaoliao2.config;


/**
 * Created by Dingkang Qin on 2017/9/20.
 * emails: qindingkang@huashantech.cn
 */

public class NetConfig {

    private static boolean IS_ONLINE_MODE=false;
    private static String BASE_URL_ONLINE_MODE= "https://api.chat-china.com/liaobei/";
    private static String BASE_URL_TEST_MODE= "https://liaoliao.fightinghang.cn/liaobei/";
    public static String BASE_URL=getBaseUrl();
    public static String VERIFICATION_URL="/liaobei/api/v1.0/getVerificationCode";
    public static String LOGIN_URL="/liaobei/api/v1.0/login";
    public static long APP_SERVER_CONNECT_TIME_OUT=15;


    private static String getBaseUrl(){
        if (IS_ONLINE_MODE){
            return BASE_URL_ONLINE_MODE;
        }else {
            return BASE_URL_TEST_MODE;
        }
    }
}
