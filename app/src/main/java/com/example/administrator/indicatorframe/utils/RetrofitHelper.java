package com.example.administrator.indicatorframe.utils;

import com.example.administrator.indicatorframe.config.UrlConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2016-08-12.
 */
public class RetrofitHelper {

    private static RetrofitHelper instance ;

    private RetrofitHelper() {

    }

    public static synchronized RetrofitHelper getInstance(){
        if(instance == null){
            instance = new RetrofitHelper() ;
        }
        return instance ;
    }

    public Retrofit retrofit ;
    public Gson gson ;

    public <T> T createRetrofitService(Class<T> service) {
        if (retrofit == null) {
            createGson();
            initRetrofit();
        }
        return retrofit.create(service);
    }

    private void initRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl(UrlConfig.Path.FEATURED_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    private void createGson() {
        gson = new GsonBuilder()
                .serializeNulls()
                .create();
    }
}
