package com.rainy.webviewproject.dsbridge;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.rainy.webviewproject.R;

public class DsBridgeActivity extends AppCompatActivity {
    private DWebView dWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ds_bridge);

        dWebView = (DWebView) findViewById(R.id.dWebView);

        dWebView.setJavascriptInterface(new JsApi());

        dWebView.clearCache(true);
        dWebView.loadUrl("file:///android_asset/test1.html");
        dWebView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
//                dWebView.callHandler("test",new Object[]{1,"hello"},new CompletionHandler(){
//                    @Override
//                    public void complete(String retValue) {
//                        Log.d("jsbridge","call succeed,return value is "+retValue);
//                    }
//                });

              dWebView.callHandler("test",null);
            }
        });

//        dWebView.evaluateJavascript("testNoVar()");
        dWebView.evaluateJavascript("testNoVar", new ValueCallback<String>() {
            @Override
            public void onReceiveValue(String value) {
                Log.d("jsbridge", "onReceiveValue value=" + value);
            }
        });
    }
}
