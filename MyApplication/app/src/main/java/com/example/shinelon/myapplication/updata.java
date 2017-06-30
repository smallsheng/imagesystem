package com.example.shinelon.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class updata extends AppCompatActivity {

    @Override
       protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updata);
        WebView webView2 = (WebView)findViewById(R.id.web_view2);
        webView2.getSettings().setJavaScriptEnabled(true);
        webView2.setWebViewClient(new WebViewClient());
        webView2.loadUrl("http://music.baidu.com/artist/92456597");
            }
        }

