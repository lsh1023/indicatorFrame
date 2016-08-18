package com.example.administrator.indicatorframe.skillfragment;

import com.example.administrator.indicatorframe.bean.FeaturedBean;
import com.example.administrator.indicatorframe.utils.HttpUtils;
import java.util.HashMap;

/**
 * Created by wanxin on 2016-08-12.
 */
public class FeaturedSkillPresenter implements FeaturedSkillConstract.SkillPresenter{
    private FeaturedSkillConstract.SkillModel model ;

    private FeaturedSkillConstract.SkillView view ;

    public FeaturedSkillPresenter(FeaturedSkillConstract.SkillView view ,FeaturedSkillConstract.SkillModel model) {
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
