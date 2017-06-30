package com.example.shinelon.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class DayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day);
        WebView webView3 = (WebView)findViewById(R.id.web_view3);
        webView3.getSettings().setJavaScriptEnabled(true);
        webView3.setWebViewClient(new WebViewClient());
        //页面链接跳转“每日一图”的管理员APP2
        webView3.loadUrl("http://www.qiushibaike.com");
    }
}
