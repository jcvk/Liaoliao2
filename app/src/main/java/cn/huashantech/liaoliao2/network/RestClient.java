package cn.huashantech.liaoliao2.network;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import cn.huashantech.liaoliao2.config.NetConfig;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Dingkang Qin on 2017/9/20.
 * emails: qindingkang@huashantech.cn
 */

public class RestClient {

    private static Retrofit retrofit;
    private static OkHttpClient okHttpClient;
    private static APIService apiService;

    public static APIService getApiService(){
        if (apiService==null){
            apiService=getRetrofit().create(APIService.class);
        }

        return apiService;
    }

    private static Retrofit getRetrofit(){
        if (retrofit==null){
            GsonBuilder builder=new GsonBuilder();

            builder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
                @Override
                public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                    return new Date(json.getAsJsonPrimitive().getAsLong());
                }
            });

            builder.registerTypeAdapter(Date.class, new JsonSerializer<Date>() {
                @Override
                public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
                    return new JsonPrimitive(src.getTime());
                }
            });

            Gson gson=builder.create();
            retrofit=new Retrofit.Builder()
                    .baseUrl(NetConfig.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(getClient())
                    .build();
        }

        return retrofit;
    }


    private static OkHttpClient getClient(){
        if (okHttpClient==null){
            okHttpClient=new OkHttpClient.Builder()
                    .hostnameVerifier(new HostnameVerifier() {
                        @Override
                        public boolean verify(String hostname, SSLSession session) {
                            return true;
                        }
                    })
                    .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC))
                    .addNetworkInterceptor(new NetInterceptor())
                    .connectTimeout(NetConfig.APP_SERVER_CONNECT_TIME_OUT, TimeUnit.SECONDS)
                    .retryOnConnectionFailure(true)
                    .build();
        }
        return okHttpClient;
    }






}
