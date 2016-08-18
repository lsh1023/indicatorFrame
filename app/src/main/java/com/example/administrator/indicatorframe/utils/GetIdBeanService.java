package com.example.administrator.indicatorframe.utils;

import com.example.administrator.indicatorframe.bean.FeaturedIdBean;
import com.example.administrator.indicatorframe.config.UrlConfig;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by Administrator on 2016-08-12.
 */
public interface GetIdBeanService {
    @GET(UrlConfig.Path.FEATURED_ID_URL)
    Call<FeaturedIdBean> getIdBean(@QueryMap() HashMap<String, String> idParams) ;
}
