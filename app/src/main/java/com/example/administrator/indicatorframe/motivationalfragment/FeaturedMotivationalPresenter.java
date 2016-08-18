package com.example.administrator.indicatorframe.motivationalfragment;

import com.example.administrator.indicatorframe.bean.FeaturedBean;
import com.example.administrator.indicatorframe.utils.HttpUtils;

import java.util.HashMap;

/**
 * Created by Administrator on 2016-08-12.
 */
public class FeaturedMotivationalPresenter implements FeaturedMotivationalConstract.MotivationalPresenter{

    private FeaturedMotivationalConstract.MotivationalModel model;
    private FeaturedMotivationalConstract.MotivationalView view ;
    public FeaturedMotivationalPresenter(FeaturedMotivationalConstract.MotivationalView view , FeaturedMotivationalConstract.MotivationalModel model){
        this.view = view ;
        this.model = model ;
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
