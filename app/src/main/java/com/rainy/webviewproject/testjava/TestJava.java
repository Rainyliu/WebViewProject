package com.rainy.webviewproject.testjava;

import android.util.Log;

import java.io.File;

/**
 * 文件相关的类
 * Author: Rainy <br>
 * Description: WebViewProject <br>
 * Since: 2017/2/7 0007 17:42 <br>
 */

public class TestJava {
    private static final String TAG = "TestJava";
    public static void main(String args[]){
        File file = new File("d:\\demo.txt");
        Log.d(TAG, "main: ======fileName"+file.getName());
    }
}
