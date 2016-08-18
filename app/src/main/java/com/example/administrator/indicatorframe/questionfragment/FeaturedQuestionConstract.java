package com.example.administrator.indicatorframe.questionfragment;

import com.example.administrator.indicatorframe.bean.FeaturedBean;
import com.example.administrator.indicatorframe.utils.HttpUtils;

import java.util.HashMap;
import java.util.List;

/**
 * Created by wanxin on 2016-08-12.
 */
public class FeaturedQuestionConstract {
    public interface QuestionView{
        public void onGetBeanSuccess(List<FeaturedBean.InfosFeaturedBean> infosQuestionBeens);
    }

    public interface QuestionModel{
        public void getData(HashMap<String,String> params , HttpUtils.HttpCallBack<FeaturedBean> callBack);
    }

    public interface QuestionPresenter{
        public void getData(HashMap<String,String> params);
    }
}
