package com.example.administrator.indicatorframe.motivationalfragment;

import com.example.administrator.indicatorframe.bean.FeaturedBean;
import com.example.administrator.indicatorframe.utils.HttpUtils;

import java.util.HashMap;

/**
 * Created by Administrator on 2016-08-12.
 */
public class FeaturedMotivationalModel implements FeaturedMotivationalConstract.MotivationalModel{
    @Override
    public void getData(HashMap<String, String> params, HttpUtils.HttpCallBack<FeaturedBean> callBack) {
        HttpUtils.getInstance().getJsonData(params,callBack);
    }
}
