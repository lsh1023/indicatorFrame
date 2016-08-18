package com.example.administrator.indicatorframe.dietfragment;

import android.util.Log;

import com.example.administrator.indicatorframe.bean.FeaturedBean;
import com.example.administrator.indicatorframe.utils.HttpUtils;

import java.util.HashMap;

/**
 * Created by Administrator on 2016-08-12.
 */
public class FeaturedDietModel implements FeaturedDietConstract.DietModel{

    @Override
    public void getData(HashMap<String, String> params, HttpUtils.HttpCallBack<FeaturedBean> callBack) {
        HttpUtils.getInstance().getJsonData(params,callBack);
        Log.i("TAG...........","我执行到这儿了");
    }
}
