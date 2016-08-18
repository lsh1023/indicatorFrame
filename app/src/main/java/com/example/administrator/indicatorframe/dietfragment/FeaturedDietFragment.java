package com.example.administrator.indicatorframe.dietfragment;


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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FeaturedDietFragment extends Fragment implements FeaturedDietConstract.DietView{

    //声明MVP
    private FeaturedDietConstract.DietModel model;
    private FeaturedDietConstract.DietPresenter presenter;
    //声明数据源
    private List<FeaturedBean.InfosFeaturedBean> mList;
    //声明Handler
    private Handler handler = new Handler();
    //声明RecyclerView
    private RecyclerView recyclerView;
    //声明适配器
    private FeaturedDietFragmentAdapter mAdapter ;
    //加载当前的页码
    private int page = 1 ;
    private int page_size =20 ;
    private static final String CAT = "1";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_featured_diet, container, false);
        //初始化Model,Presenter
        model = new FeaturedDietModel();
        presenter = new FeaturedDietPresenter(this,model);
        presenter.getData(initParams());

       /* //通知要下载数据了
        //TODO:先判断本地有没有数据bean本地有没有
        File file = new File(SDCardUtils.getSDCardPath()+"featured"+File.separator+String.valueOf(page_size)+".txt");
        if(file.exists()){
            //TODO:文件存在的话  文件存在就可以直接读取了啊
            Log.i("SD","文件存在我直接读取了-------");
            new Thread(){
                @Override
                public void run() {
                    super.run();
                    try {
                        FileInputStream inputStream = new FileInputStream(SDCardUtils.getSDCardPath()+ "featured"+File.separator+String.valueOf(page_size)+".txt");
                        String json = StreamUtils.readStream(inputStream);
                        Log.i("SD",json);
                        Gson gson = new Gson();
                        FeaturedBean featuredBean = gson.fromJson(json, FeaturedBean.class);
                        Message message = Message.obtain();
                        message.obj = featuredBean;
                        handler.sendMessage(message);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }.start();

        }else{
            presenter.getData(initParams());
        }*/

        //初始化listview需要显示的数据
        mList = new ArrayList<>();
        //初始化适配器
        mAdapter = new FeaturedDietFragmentAdapter(R.layout.find_featured_fragment_recycleview_item2,mList);
        recyclerView = (RecyclerView) view.findViewById(R.id.find_featured_diet_frg_recycleview);
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
                ++page;
                page_size = 20 * page ;
                Log.i("TTTTTTTTTTTT",""+page);
                presenter.getData(initParams());
                /*File file = new File(SDCardUtils.getSDCardPath()+ "featured"+File.separator+String.valueOf(page_size)+".txt");
                if(file.exists()){
                    //TODO:文件存在的话  文件存在就可以直接读取了啊
                    Log.i("SD","文件存在我直接读取了-------"+SDCardUtils.getSDCardPath());

                    new Thread(){
                        @Override
                        public void run() {
                            super.run();
                            try {
                                FileInputStream inputStream = new FileInputStream(SDCardUtils.getSDCardPath()+ "home"+File.separator+String.valueOf(page_size)+".txt");
                                String json = StreamUtils.readStream(inputStream);
                                Gson gson = new Gson();
                                FeaturedBean featuredBean = gson.fromJson(json, FeaturedBean.class);
                                Message message = Message.obtain();
                                message.obj = featuredBean;
                                handler.sendMessage(message);
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }
                        }
                    }.start();

                }else{
                    presenter.getData(initParams());
                }*/
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
    public void onGetBeanSuccess(final List<FeaturedBean.InfosFeaturedBean> infosDietBeens) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                if(mList.size()>1){
                    mList.clear();
                    List<FeaturedBean.InfosFeaturedBean> repeatList = new ArrayList<>();
                    repeatList.addAll(infosDietBeens);
                    mAdapter.notifyDataChangedAfterLoadMore(repeatList,true);
                }else{
                    mList.addAll(infosDietBeens);
                    mAdapter.notifyDataSetChanged();
                }
            }
        });
    }
}
