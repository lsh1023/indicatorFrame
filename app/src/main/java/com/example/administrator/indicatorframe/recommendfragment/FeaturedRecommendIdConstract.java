package com.example.administrator.indicatorframe.recommendfragment;

import com.example.administrator.indicatorframe.bean.FeaturedIdBean;
import com.example.administrator.indicatorframe.utils.HttpIdUtils;

import java.util.HashMap;
import java.util.List;

/**
 * Created by wanxin on 2016-08-12.
 */
public class FeaturedRecommendIdConstract {
    public interface RecommendIdView{
        public void onGetIdBeanSuccess(List<FeaturedIdBean.InfoFeedsFeaturedIdBean> infoFeedsFeaturedIdBeans);
    }

    public interface RecommendIdModel{
        public void getIdData(HashMap<String, String> idParams , HttpIdUtils.HttpCallBack<FeaturedIdBean> callBack);
    }

    public interface RecommendIdPresenter{
        public void getIdData(HashMap<String, String> idParams);
    }
}
