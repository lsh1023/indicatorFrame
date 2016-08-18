package com.example.administrator.indicatorframe.recommendfragment;

import android.content.Context;
import android.os.Handler;

/**
 * Created by wanxin on 2016-08-12.
 */
public class FeaturedRecommendPresenter implements FeaturedRecommendConstract.RecommendPresenter{
    private FeaturedRecommendConstract.RecommendModel model ;

    private FeaturedRecommendConstract.RecommendView view ;

    public FeaturedRecommendPresenter(FeaturedRecommendConstract.RecommendView view ,FeaturedRecommendConstract.RecommendModel model) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void getData(String params, Context context, Handler handler) {
        model.getData(params,context,handler);
    }
}
