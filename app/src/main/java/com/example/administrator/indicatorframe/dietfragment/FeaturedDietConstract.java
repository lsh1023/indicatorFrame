package com.example.administrator.indicatorframe.dietfragment;

import com.example.administrator.indicatorframe.bean.FeaturedBean;
import com.example.administrator.indicatorframe.utils.HttpUtils;

import java.util.HashMap;
import java.util.List;


/**
 * Created by Administrator on 2016-08-12.
 */
public class FeaturedDietConstract {

    public interface DietView{
        public void onGetBeanSuccess(List<FeaturedBean.InfosFeaturedBean> infosDietBeens);
    }

    public interface DietModel{
        public void getData(HashMap<String,String> params , HttpUtils.HttpCallBack<FeaturedBean> callBack);
    }

    public interface DietPresenter{
        public void getData(HashMap<String,String> params);
    }

}
