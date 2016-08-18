package com.example.administrator.indicatorframe.skillfragment;

import com.example.administrator.indicatorframe.bean.FeaturedBean;
import com.example.administrator.indicatorframe.utils.HttpUtils;

import java.util.HashMap;
import java.util.List;

/**
 * Created by wanxin on 2016-08-12.
 */
public class FeaturedSkillConstract {
    public interface SkillView{
        public void onGetBeanSuccess(List<FeaturedBean.InfosFeaturedBean> infosSkillBeens);
    }

    public interface SkillModel{
        public void getData(HashMap<String,String> params , HttpUtils.HttpCallBack<FeaturedBean> callBack);
    }

    public interface SkillPresenter{
        public void getData(HashMap<String,String> params);
    }
}
