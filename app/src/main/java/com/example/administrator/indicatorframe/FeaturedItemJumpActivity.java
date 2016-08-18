package com.example.administrator.indicatorframe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class FeaturedItemJumpActivity extends AppCompatActivity {

    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_featured_item_jump);
        String path = getIntent().getStringExtra("path");
        webView = (WebView) findViewById(R.id.featured_item_jump_click_webView);
        webView.loadUrl(path);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setPluginState(WebSettings.PluginState.ON);
        webView.setWebChromeClient(new WebChromeClient());
//        WebSettings settings = webView.getSettings();
//        settings.setCacheMode(WebSettings.LOAD_DEFAULT);
//        settings.setUseWideViewPort(true);//设置此属性，可任意比例缩放
//        settings.setLoadWithOverviewMode(true);
        //settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
    }

    //返回上一个界面
    public void goback(View v){
        finish();
    }
}
