package com.example.administrator.indicatorframe.find.finditem.messagefragment;

import java.util.HashMap;

/**
 * Created by Administrator on 2016-08-15.
 */
public class MessageFragmentAdapter {
    public interface DietView{
        public void onGetBeanSuccess();
    }

    public interface DietModel{
        public void getData(HashMap<String,String> params);
    }

    public interface DietPresenter{
        public void getData(HashMap<String,String> params);
    }
}
