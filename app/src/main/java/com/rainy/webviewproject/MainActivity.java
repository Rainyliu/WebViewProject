package com.rainy.webviewproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private WebView mWebView;
    private static final String TAG = "WebViewActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWebView = (WebView) findViewById(R.id.webview);

        //加载assets文件夹下的test.html页面
        mWebView.loadUrl("file:///android_asset/test.html");
        //加载网页
//        mWebView.loadUrl("http://www.baidu.com");
        mWebView.addJavascriptInterface(new JsInteration(),"ios");
        //想要调用js方法那么就必须让webView支持
        WebSettings webSettings = mWebView.getSettings();
        // 设置为可调用js方法
        webSettings.setJavaScriptEnabled(true);

//        若调用的js方法没有返回值，则直接可以调用,其中do是js中的方法；
//        mWebView.loadUrl("javascript:do()");

//        若有返回值时我们可以调用mWebView.evaluateJavascript()方法：
//        mWebView.evaluateJavascript("sum(1,2)", new ValueCallback<String>() {
//            @Override
//            public void onReceiveValue(String value) {
//                Log.d(TAG, "onReceiveValue value=" + value);
//            }
//        });
        //在自己的app中打开设置setWebViewClient：
        //拦截html中的点击事件
        mWebView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //拦截url事件
                if (url.equals("file:///android_asset/test2.html")) {
                    Log.e(TAG, "shouldOverrideUrlLoading: " + url);
//                    Toast.makeText(MainActivity.this,"aaaaaaaaaaaaaaaaaaa",Toast.LENGTH_LONG).show();
                    startActivity(new Intent(MainActivity.this,SecondActivity.class));
                    return true;
                } else {
                    mWebView.loadUrl(url);
                    return false;
                }
            }
        });



    }

    //Android调用有返回值js方法
    public void onClick(View v) {

        mWebView.evaluateJavascript("sum(1,2)", new ValueCallback<String>() {
            @Override
            public void onReceiveValue(String value) {
                Log.e(TAG, "onReceiveValue value=" + value);
                Toast.makeText(MainActivity.this,"value=" + value,Toast.LENGTH_LONG).show();
            }
        });
    }
}
