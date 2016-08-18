package com.example.administrator.indicatorframe.recommendfragment;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.administrator.indicatorframe.FeaturedItemJumpActivity;
import com.example.administrator.indicatorframe.R;
import com.example.administrator.indicatorframe.bean.FeaturedBean;
import com.example.administrator.indicatorframe.bean.FeaturedIdBean;
import com.example.administrator.indicatorframe.config.UrlConfig;
import com.example.administrator.indicatorframe.utils.DividerItemDecoration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FeaturedRecommendFragment extends Fragment implements FeaturedRecommendConstract.RecommendView ,FeaturedRecommendIdConstract.RecommendIdView {


    //声明MVP
    private FeaturedRecommendIdConstract.RecommendIdModel idModel ;
    private FeaturedRecommendIdConstract.RecommendIdPresenter idPresenter;
    //声明id数据源
    private List<FeaturedIdBean.InfoFeedsFeaturedIdBean> idList;
    //声明MVP
    private FeaturedRecommendConstract.RecommendModel model ;
    private FeaturedRecommendConstract.RecommendPresenter presenter;
    //声明数据源
    private List<FeaturedBean.InfosFeaturedBean> mList;

    //声明适配器
    private FeaturedRecommendFragmentAdapter mAdapter ;
    //声明Recycleview
    private RecyclerView mRecyclerView;
    //声明Handler
    private Handler handler ;
    //声明存放id的集合
    private List<String> mIdList;
    //声明加载的页数
    private int page ;
    //声明加载的条目数量
    private int page_size =20 ;
    private static final String CAT = "3" ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recommend_featured, container, false);

        //初始化IdMvp
        initIdMvp();
        idList = new ArrayList<>();
        mIdList = new ArrayList<>();
        //初始化mIdList
        initMIdList();
        //初始化Mvp
        initMvp();
        mList = new ArrayList<>();
        mAdapter = new FeaturedRecommendFragmentAdapter(R.layout.find_featured_fragment_recycleview_listview_item,mList);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rlv_outter_recommend);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(
                getContext(), DividerItemDecoration.VERTICAL_LIST));
        mRecyclerView.smoothScrollToPosition(page_size);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.openLoadMore(1,true);
        mAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                ++page;
                page_size = 20 * page ;
                Log.i("TTTTTTTTTTTT",""+page);
                idPresenter.getIdData(initIdParams());
                presenter.getData(initParams());
            }
        });
        mAdapter.setOnRecyclerViewItemClickListener(new BaseQuickAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getActivity(), FeaturedItemJumpActivity.class);
                intent.putExtra("path",mList.get(position).getUrl());
                startActivity(intent);
            }
        });
        return view ;
    }

    private void initMIdList() {
        for(int i = 0 ;i<idList.size();i++){
            mIdList.add(String.valueOf(idList.get(i).getInfoId()));

        }
    }

    //获取布局文件里面需要的Bean类的MVP的框架
    private void initMvp() {
        model = new FeaturedRecommendModel();
        presenter = new FeaturedRecommendPresenter(this,model);
        presenter.getData(initParams());
    }

    //获取布局文件里面需要的Bean类id的MVP框架
    private void initIdMvp() {
        idModel = new FeaturedRecommendIdModel();
        idPresenter = new FeaturedRecommendIdPresenter(this,idModel);
        idPresenter.getIdData(initIdParams());
    }

    //获取布局文件里面需要的Bean类的id的query集合
    private HashMap<String,String> initIdParams() {
        HashMap<String,String> idParams = new HashMap<>();
        idParams.put(UrlConfig.FeaturedRecommendIdKey.PAGE_SIZE,String.valueOf(page_size));
        return idParams;
    }
    //获取布局文件里面需要的Bean类的query集合
    private HashMap<String, String> initParams() {
        HashMap<String, String> params = new HashMap<>();
        params.put(UrlConfig.PublicKey.PAGE_SIZE,String.valueOf(page_size));
        params.put(UrlConfig.PublicKey.CAT,CAT);
        return params ;
    }

    @Override
    public void onGetBeanSuccess(final List<FeaturedBean.InfosFeaturedBean> infosRecommendBeens) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                if(mList.size()>1){
                    mList.clear();
                    List<FeaturedBean.InfosFeaturedBean> repeatList = new ArrayList<>();
                    repeatList.addAll(infosRecommendBeens);
                    mAdapter.notifyDataChangedAfterLoadMore(repeatList,true);
                }else{
                    mList.addAll(infosRecommendBeens);
                    mAdapter.notifyDataSetChanged();
                }
            }
        });
    }
    @Override
    public void onGetIdBeanSuccess(List<FeaturedIdBean.InfoFeedsFeaturedIdBean> infoFeedsFeaturedIdBeans) {
//        if(idList.size()>1){
//            idList.clear();
//            List<FeaturedIdBean.InfoFeedsFeaturedIdBean> repeatList = new ArrayList<>();
//            repeatList.addAll(infoFeedsFeaturedIdBeans);
//        }else{
//            idList.addAll(infoFeedsFeaturedIdBeans);
//        }
        idList.clear();
        idList.addAll(infoFeedsFeaturedIdBeans);
    }

}
