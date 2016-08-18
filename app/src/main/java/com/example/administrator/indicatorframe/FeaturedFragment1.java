package com.example.administrator.indicatorframe;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.indicatorframe.dietfragment.FeaturedDietFragment;
import com.example.administrator.indicatorframe.motivationalfragment.FeaturedMotivationalFragment;
import com.example.administrator.indicatorframe.questionfragment.FeaturedQuestionFragment;
import com.example.administrator.indicatorframe.skillfragment.FeaturedSkillFragment;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FeaturedFragment1 extends Fragment {

    private ViewPager mViewPager;
    private List<Fragment> mList;
    private FeaturedViewPagerAdapter mAdapter;
    private TabLayout mTabLayout;
    private String[] mTitle ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_featured_fragment1, container, false);

        mViewPager = (ViewPager) view.findViewById(R.id.vp_featured);
        mTabLayout = (TabLayout) view.findViewById(R.id.tl_featured);
        mTitle = new String[]{"推荐", "饮食", "问答", "励志","技巧"};
        mList = new ArrayList<>();
        //mList.add(new FeaturedRecommendFragment());
        mList.add(new FeaturedDietFragment());
        mList.add(new FeaturedDietFragment());
        mList.add(new FeaturedQuestionFragment());
        mList.add(new FeaturedMotivationalFragment());
        mList.add(new FeaturedSkillFragment());
        mAdapter = new FeaturedViewPagerAdapter(getChildFragmentManager(),mList,mTitle);
        mTabLayout.setupWithViewPager(mViewPager);
        mViewPager.setOffscreenPageLimit(5);
        mViewPager.setAdapter(mAdapter);
//        mViewPager.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                return false;
//            }
//        });
        return view;
    }
}
