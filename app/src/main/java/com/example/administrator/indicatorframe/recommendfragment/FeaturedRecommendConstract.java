package com.example.administrator.indicatorframe.recommendfragment;

import com.example.administrator.indicatorframe.bean.FeaturedBean;
import com.example.administrator.indicatorframe.utils.HttpRecommendUtils;

import java.util.HashMap;
import java.util.List;

/**
 * Created by wanxin on 2016-08-12.
 */
public class FeaturedRecommendConstract {
    public interface RecommendView{
        public void onGetBeanSuccess(List<FeaturedBean.InfosFeaturedBean> infosRecommendBeens);
    }

    public interface RecommendModel{
        public void getData(HashMap<String, String> params, HttpRecommendUtils.HttpCallBack<FeaturedBean> callBack);
    }

    public interface RecommendPresenter{
        public void getData(HashMap<String, String> params);
    }
}
