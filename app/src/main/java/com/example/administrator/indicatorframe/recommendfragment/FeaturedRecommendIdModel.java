package com.example.administrator.indicatorframe.recommendfragment;

import com.example.administrator.indicatorframe.bean.FeaturedIdBean;
import com.example.administrator.indicatorframe.utils.HttpIdUtils;

import java.util.HashMap;

/**
 * Created by wanxin on 2016-08-12.
 */
public class FeaturedRecommendIdModel implements FeaturedRecommendIdConstract.RecommendIdModel{

    @Override
    public void getIdData(HashMap<String, String> idParams, HttpIdUtils.HttpCallBack<FeaturedIdBean> callBack) {
        HttpIdUtils.getInstance().getJsonData(idParams,callBack);
    }
}
