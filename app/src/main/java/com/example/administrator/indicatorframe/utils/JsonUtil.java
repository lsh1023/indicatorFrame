package com.example.administrator.indicatorframe.utils;

import com.example.administrator.indicatorframe.bean.FeaturedBean;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangke on 16/7/14.
 */
public class JsonUtil {


    public static List<FeaturedBean> getFeaturedBean(String jsonString) {
        List<FeaturedBean> featuredBean = new ArrayList<>();
        //创建gson对象
        Gson gson = new Gson();

        //获取数据的类型
        Type type = new TypeToken<List<FeaturedBean>>() {
        }.getType();
        //解析
        featuredBean = gson.fromJson(jsonString, type);

        return featuredBean;
    }

}
