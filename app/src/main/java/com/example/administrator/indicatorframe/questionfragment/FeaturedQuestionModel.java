package com.example.administrator.indicatorframe.questionfragment;

import com.example.administrator.indicatorframe.bean.FeaturedBean;
import com.example.administrator.indicatorframe.utils.HttpUtils;

import java.util.HashMap;

/**
 * Created by wanxin on 2016-08-12.
 */
public class FeaturedQuestionModel implements FeaturedQuestionConstract.QuestionModel{
    @Override
    public void getData(HashMap<String, String> params, HttpUtils.HttpCallBack<FeaturedBean> callBack) {
        HttpUtils.getInstance().getJsonData(params,callBack);
    }
}
