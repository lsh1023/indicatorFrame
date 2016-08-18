package com.example.administrator.indicatorframe.find.finditem.hideleg;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Window;
import android.widget.RadioGroup;

import com.example.administrator.indicatorframe.R;
import com.example.administrator.indicatorframe.dietfragment.FeaturedDietFragment;
import com.example.administrator.indicatorframe.questionfragment.FeaturedQuestionFragment;

public class HideLegActivity extends AppCompatActivity {

    private FragmentManager fragmentManager ;
    private FeaturedDietFragment fragment1;
    private FeaturedQuestionFragment fragment2;
    private RadioGroup mRadioGroup;
    public static final int SELECTED_FEATURED = R.id.rb_message;
    public static final int SELECTED_FRUME = R.id.rb_post;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_hide_leg);

        mRadioGroup = (RadioGroup) findViewById(R.id.rb_tab_group);
        initFragment();
        selectFragment(SELECTED_FEATURED);
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int position) {
                selectFragment(position);

            }
        });
    }

    private void selectFragment(int position) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.hide(fragment1).hide(fragment2);
        switch (position) {
            case SELECTED_FEATURED:
                transaction.show(fragment1);
                Log.i("TAG","我可以显示了");
                break;
            case SELECTED_FRUME:
                transaction.show(fragment2);
                Log.i("TAG","我可以显示了");
                break;
        }
        transaction.commit();
    }

    private void initFragment() {
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        fragment1 = new FeaturedDietFragment();
        fragment2 = new FeaturedQuestionFragment();
        transaction.add(R.id.fl_search_container, fragment1);
        Log.i("TAG","我已经创建成功了");
        transaction.add(R.id.fl_search_container, fragment2);
        Log.i("TAG","我已经创建成功了");
        transaction.hide(fragment1).hide(fragment2);
        transaction.commit();
    }
}
