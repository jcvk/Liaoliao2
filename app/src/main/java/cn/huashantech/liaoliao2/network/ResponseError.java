package cn.huashantech.liaoliao2.network;

/**
 * Created by Dingkang Qin on 2017/9/23.
 * emails: qindingkang@huashantech.cn
 */

public class ResponseError {

    public static void dealError(int code){

        switch (code){
            case 401:
                errorFor401();
                break;
            default:
                break;

        }

    }

    private static void errorFor401(){
        // TODO: 2017/9/23  
    }

}
