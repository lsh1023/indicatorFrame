package com.example.administrator.indicatorframe.questionfragment;

import com.example.administrator.indicatorframe.bean.FeaturedBean;
import com.example.administrator.indicatorframe.utils.HttpUtils;

import java.util.HashMap;

/**
 * Created by wanxin on 2016-08-12.
 */
public class FeaturedQuestionPresenter implements FeaturedQuestionConstract.QuestionPresenter{
    private FeaturedQuestionConstract.QuestionModel model ;
    private FeaturedQuestionConstract.QuestionView view ;

    public FeaturedQuestionPresenter(FeaturedQuestionConstract.QuestionView view ,FeaturedQuestionConstract.QuestionModel model) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void getData(HashMap<String, String> params) {
        model.getData(params, new HttpUtils.HttpCallBack<FeaturedBean>() {
            @Override
            public void onSucess(FeaturedBean featuredBean) {
                view.onGetBeanSuccess(featuredBean.getInfos());
            }
        });
    }
}
