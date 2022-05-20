package com.example.kidseduc.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import com.example.kidseduc.R;

public class HtmlActivity extends AppCompatActivity {

    WebView html ;
    final String descriptionUsingWebView = "<h2>Display HTML code in Android using WebView</h2><p>In this tutorial, we show you how to display HTML code in Android using WebView</p>";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        html = new WebView(this);
        setContentView(html);
        // String htmlText = "<html><head><style type=\"text/css\">{color:green; text-align:left;} </style></head>";
        // Load a webpage
        // html.loadData(htmlText, "text/html", "utf-8");
       //html.loadUrl("https://pbskids.org/");
        html.loadDataWithBaseURL(null, descriptionUsingWebView, "text/html", "utf-8", null);
    }
}