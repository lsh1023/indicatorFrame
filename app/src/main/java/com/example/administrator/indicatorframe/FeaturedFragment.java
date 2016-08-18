package com.example.administrator.indicatorframe;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.example.administrator.indicatorframe.dietfragment.FeaturedDietFragment;
import com.example.administrator.indicatorframe.motivationalfragment.FeaturedMotivationalFragment;
import com.example.administrator.indicatorframe.questionfragment.FeaturedQuestionFragment;
import com.example.administrator.indicatorframe.recommendfragment.FeaturedRecommendFragment;
import com.example.administrator.indicatorframe.skillfragment.FeaturedSkillFragment;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FeaturedFragment extends Fragment {

    private FragmentManager fragmentManager ;
    private FeaturedRecommendFragment recommendFragment;
    private FeaturedDietFragment dietFragment;
    private FeaturedQuestionFragment questionFragment;
    private FeaturedMotivationalFragment motivationalFragment;
    private FeaturedSkillFragment skillFragment;
    private RadioGroup mRadioGroup;
    private List<Fragment> mList;
    public static final int SELECTED_RECOMMEND = R.id.rb_recommend;
    public static final int SELECTED_DIET = R.id.rb_diet;
    public static final int SELECTED_QUESTION = R.id.rb_question;
    public static final int SELECTED_MOTIVATIONAL = R.id.rb_motivational;
    public static final int SELECTED_SKILL = R.id.rb_skill;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_featured, container, false);
        mRadioGroup = (RadioGroup) view.findViewById(R.id.rb_tab_group);
        initFragment() ;
        //selectFragment(SELECTED_RECOMMEND);
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int position) {
                selectFragment(position);

            }
        });
        return view;
    }

    private void selectFragment(int position) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.hide(recommendFragment).hide(dietFragment).hide(questionFragment).hide(motivationalFragment).hide(skillFragment);

        switch (position) {
            case SELECTED_RECOMMEND:
                transaction.show(recommendFragment);
                Log.i("TAG","我可以显示了");
                break;
            case SELECTED_DIET:
                transaction.show(dietFragment);
                Log.i("TAG","我可以显示了");
                break;
            case SELECTED_QUESTION:
                transaction.show(questionFragment);
                Log.i("TAG","我可以显示了");
                break;
            case SELECTED_MOTIVATIONAL:
                transaction.show(motivationalFragment);
                Log.i("TAG","我可以显示了");
                break;
            case SELECTED_SKILL:
                transaction.show(skillFragment);
                Log.i("TAG","我可以显示了");
                break;
        }
        transaction.commit();
    }

    private void initFragment() {
        fragmentManager = getChildFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        recommendFragment = new FeaturedRecommendFragment();
        dietFragment = new FeaturedDietFragment();
        questionFragment = new FeaturedQuestionFragment();
        motivationalFragment = new FeaturedMotivationalFragment();
        skillFragment = new FeaturedSkillFragment();
        transaction.add(R.id.fragme_container, recommendFragment);
        Log.i("TAG","我已经创建成功了");
        transaction.add(R.id.fragme_container, dietFragment);
        Log.i("TAG","我已经创建成功了");
        transaction.add(R.id.fragme_container, questionFragment);
        Log.i("TAG","我已经创建成功了");
        transaction.add(R.id.fragme_container, motivationalFragment);
        Log.i("TAG","我已经创建成功了");
        transaction.add(R.id.fragme_container, skillFragment);
        Log.i("TAG","我已经创建成功了");
        transaction.hide(recommendFragment).hide(dietFragment).hide(questionFragment).hide(motivationalFragment).hide(skillFragment);
        transaction.commit();
    }

    /*public void onDetach() {
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
    }*/

}
