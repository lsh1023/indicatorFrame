package com.example.administrator.indicatorframe.skillfragment;


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
import com.example.administrator.indicatorframe.config.UrlConfig;
import com.example.administrator.indicatorframe.utils.DividerItemDecoration;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FeaturedSkillFragment extends Fragment implements FeaturedSkillConstract.SkillView{

    //声明MVP
    private FeaturedSkillConstract.SkillModel model;
    private FeaturedSkillConstract.SkillPresenter presenter ;
    //声明数据源
    private List<FeaturedBean.InfosFeaturedBean> mList;
    //声明Handler
    private Handler handler = new Handler();
    //声明RecyclerView
    private RecyclerView recyclerView;
    //声明适配器
    private FeaturedSkillFragmentAdapter mAdapter ;
    //加载当前的页码
    private int page = 1 ;
    private int page_size = 20 ;
    private static final String CAT = "4" ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_featured_skill, container, false);

        //初始化MVP
        model = new FeaturedSkillModel();
        presenter = new FeaturedSkillPresenter(this,model);
        presenter.getData(initParams());

        //初始化数据源
        mList = new ArrayList<>();
        mAdapter = new FeaturedSkillFragmentAdapter(R.layout.find_featured_fragment_recycleview_item2,mList);
        recyclerView = (RecyclerView) view.findViewById(R.id.find_featured_skill_frg_recycleview);
        //初始化RecyclerView参数
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        //设置分割线
        recyclerView.addItemDecoration(new DividerItemDecoration(
                getContext(), DividerItemDecoration.VERTICAL_LIST));
        recyclerView.smoothScrollToPosition(page_size);
        recyclerView.setAdapter(mAdapter);
        mAdapter.openLoadMore(1,true);
        mAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                ++page ;
                page_size = 20 * page ;
                Log.i("TTTTTTTTTTTT",""+page);
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

    private HashMap<String,String> initParams() {
        HashMap<String, String> params = new HashMap<>();
        params.put(UrlConfig.PublicKey.PAGE_SIZE,String.valueOf(page_size));
        params.put(UrlConfig.PublicKey.CAT,CAT);
        return params ;
    }
    @Override
    public void onGetBeanSuccess(final List<FeaturedBean.InfosFeaturedBean> infosSkillBeens) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                if(mList.size()>1){
                    mList.clear();
                    List<FeaturedBean.InfosFeaturedBean> repeatList = new ArrayList<FeaturedBean.InfosFeaturedBean>();
                    repeatList.addAll(infosSkillBeens);
                    mAdapter.notifyDataChangedAfterLoadMore(repeatList,true);
                }else{
                    mList.addAll(infosSkillBeens);
                    mAdapter.notifyDataSetChanged();
                }
            }
        });
    }

    public void onDetach() {
        super.onDetach();
        try {
            Field childFragmentManager = Fragment.class
                    .getDeclaredField("mChildFragmentManager");
            childFragmentManager.setAccessible(true);
            childFragmentManager.set(this, null);

        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
