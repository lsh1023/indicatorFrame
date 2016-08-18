package com.example.administrator.indicatorframe.utils;

import com.example.administrator.indicatorframe.bean.FeaturedBean;
import com.example.administrator.indicatorframe.config.UrlConfig;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by Administrator on 2016-08-12.
 */
public interface GetBeanService {
    @GET(UrlConfig.Path.FEATURED_URL)
    Call<FeaturedBean> getBean(@QueryMap() HashMap<String,String> params) ;
}
