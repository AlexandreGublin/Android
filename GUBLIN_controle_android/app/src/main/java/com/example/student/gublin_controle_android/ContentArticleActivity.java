package com.example.student.gublin_controle_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class ContentArticleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_article);

        Intent intent = getIntent();
        String urlContentArticle = intent.getStringExtra("url");

        WebView webview = new WebView(this);
        setContentView(webview);

        webview.loadUrl(urlContentArticle);
    }
}
