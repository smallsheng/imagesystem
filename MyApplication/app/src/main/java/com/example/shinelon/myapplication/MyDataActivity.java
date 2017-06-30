package com.example.shinelon.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MyDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_data);
        WebView webView = (WebView)findViewById(R.id.web_view);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        //页面链接跳转修改个人资料的管理员APP2
        webView.loadUrl("http://baike.sogou.com/v60957326.htm?fromTitle=%E5%8D%8E%E6%99%A8%E5%AE%87");
    }
}
