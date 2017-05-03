package com.rainy.webviewproject;

import android.webkit.JavascriptInterface;

/**
 * Author: Rainy <br>声明本地java方法，让js可以调用java中的方法
 * Description: Security <br>
 * Since: 2017/2/4 0004 18:30 <br>
 */

public class JsInteration {
    @JavascriptInterface
    public String back() {
        return "hello world ios";
    }
}
