package com.example.administrator.indicatorframe.dietfragment;

import android.util.Log;

import com.example.administrator.indicatorframe.bean.FeaturedBean;
import com.example.administrator.indicatorframe.utils.HttpUtils;

import java.util.HashMap;

/**
 * Created by Administrator on 2016-08-12.
 */
public class FeaturedDietPresenter implements FeaturedDietConstract.DietPresenter{
    private FeaturedDietConstract.DietModel model ;
    private FeaturedDietConstract.DietView view ;

    public FeaturedDietPresenter(FeaturedDietFragment view, FeaturedDietConstract.DietModel model) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void getData(HashMap<String, String> params) {
        model.getData(params, new HttpUtils.HttpCallBack<FeaturedBean>() {
            @Override
            public void onSucess(FeaturedBean featuredBean) {
                view.onGetBeanSuccess(featuredBean.getInfos());
                Log.i("TAG...........","我执行到这儿了");
            }
        });
    }
}
