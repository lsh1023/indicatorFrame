package com.example.administrator.indicatorframe.skillfragment;

import com.example.administrator.indicatorframe.bean.FeaturedBean;
import com.example.administrator.indicatorframe.utils.HttpUtils;

import java.util.HashMap;

/**
 * Created by wanxin on 2016-08-12.
 */
public class FeaturedSkillModel implements FeaturedSkillConstract.SkillModel{
    @Override
    public void getData(HashMap<String, String> params, HttpUtils.HttpCallBack<FeaturedBean> callBack) {
        HttpUtils.getInstance().getJsonData(params,callBack);
    }
}
