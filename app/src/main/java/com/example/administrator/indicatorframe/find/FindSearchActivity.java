package com.example.administrator.indicatorframe.find;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;

import com.example.administrator.indicatorframe.R;
import com.example.administrator.indicatorframe.find.finditem.hideleg.HideLegActivity;
import com.example.administrator.indicatorframe.find.finditem.reducefat.ReduceFatActivity;
import com.example.administrator.indicatorframe.find.finditem.shake.ShakeActivity;
import com.example.administrator.indicatorframe.find.finditem.stretch.StretchActivity;

public class FindSearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_find_search);
    }

    public void item1(View view){
        Intent intent = new Intent(this, HideLegActivity.class);
        startActivity(intent);
    }

    public void item2(View view){
        Intent intent = new Intent(this, ReduceFatActivity.class);
        startActivity(intent);
    }

    public void item3(View view){
        Intent intent = new Intent(this, StretchActivity.class);
        startActivity(intent);
    }

    public void item4(View view){
        Intent intent = new Intent(this, ShakeActivity.class);
        startActivity(intent);
    }
}
