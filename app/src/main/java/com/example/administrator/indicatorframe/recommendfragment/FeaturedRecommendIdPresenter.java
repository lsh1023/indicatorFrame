package com.example.administrator.indicatorframe.recommendfragment;

import com.example.administrator.indicatorframe.bean.FeaturedIdBean;
import com.example.administrator.indicatorframe.utils.HttpIdUtils;

import java.util.HashMap;

/**
 * Created by wanxin on 2016-08-12.
 */
public class FeaturedRecommendIdPresenter implements FeaturedRecommendIdConstract.RecommendIdPresenter{
    private FeaturedRecommendIdConstract.RecommendIdModel idModel ;

    private FeaturedRecommendIdConstract.RecommendIdView idView ;

    public FeaturedRecommendIdPresenter(FeaturedRecommendIdConstract.RecommendIdView idView , FeaturedRecommendIdConstract.RecommendIdModel idModel) {
        this.idModel = idModel;
        this.idView = idView;
    }
    @Override
    public void getIdData(HashMap<String, String> idParams) {
        idModel.getIdData(idParams, new HttpIdUtils.HttpCallBack<FeaturedIdBean>() {
            @Override
            public void onSucess(FeaturedIdBean featuredIdBean) {
                idView.onGetIdBeanSuccess(featuredIdBean.getInfoFeeds());
            }
        });
    }
}
