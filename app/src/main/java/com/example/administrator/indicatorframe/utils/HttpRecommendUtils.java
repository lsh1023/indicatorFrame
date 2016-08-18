package com.example.administrator.indicatorframe.utils;

import android.util.Log;

import com.example.administrator.indicatorframe.bean.FeaturedBean;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by wanxin on 2016-08-12.
 */
public class HttpRecommendUtils {
    private static HttpRecommendUtils instance ;

    public HttpRecommendUtils() {
    }

    public static synchronized HttpRecommendUtils getInstance(){
        if(instance == null){
            instance = new HttpRecommendUtils();
        }
        return instance ;
    }

    public interface HttpCallBack<T> {
        public void onSucess(T t);

    }

    public void getJsonData(final HashMap<String, String> params, final HttpCallBack<FeaturedBean> httpCallBack) {
        Call<FeaturedBean> featuredBeanCallback = RetrofitHelper
                .getInstance()
                .createRetrofitService(GetIdRecommendBeanService.class)
                .getRecommendBean(params);
        featuredBeanCallback.enqueue(new Callback<FeaturedBean>() {
            @Override
            public void onResponse(Call<FeaturedBean> call, Response<FeaturedBean> response) {
                FeaturedBean featuredBean = response.body();
                httpCallBack.onSucess(featuredBean);
            }

            @Override
            public void onFailure(Call<FeaturedBean> call, Throwable t) {
                Log.i("TAG...........","网络异常");
            }
        });
    }
}
