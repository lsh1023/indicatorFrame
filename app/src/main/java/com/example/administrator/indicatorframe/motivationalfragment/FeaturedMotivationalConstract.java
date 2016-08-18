package com.example.administrator.indicatorframe.motivationalfragment;

import com.example.administrator.indicatorframe.bean.FeaturedBean;
import com.example.administrator.indicatorframe.utils.HttpUtils;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2016-08-12.
 */
public class FeaturedMotivationalConstract {
    public interface MotivationalView{
        public void onGetBeanSuccess(List<FeaturedBean.InfosFeaturedBean> infosMotivationalBeens);
    }

    public interface MotivationalModel{
        public void getData(HashMap<String,String> params , HttpUtils.HttpCallBack<FeaturedBean> callBack);
    }

    public interface MotivationalPresenter{
        public void getData(HashMap<String,String> params);
    }
}
