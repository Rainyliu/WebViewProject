package com.rainy.webviewproject;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

/**
 * 使用本地广播是为了解决广播的安全性问题
 * 本地广播发出的广播只能在应用程序内部进行传递
 * 并且广播接收器只能接收来自本应用程序发出的广播
 * 使用LocalBroadcastManager进行管理
 * 本地广播无法通过静态注册的方式来接收的
 * 因为静态注册完全是为了让程序在未启动的情况下也能接收到广播
 * 而发送本地广播时，我们的程序已经启动了，所以没有必要通过静态注册的方式来注册广播
 *
 * 本地广播的优点：
 * 1）可以明确的知道正在发送的广播不会离开我们的程序，因此不必担心机密数据的泄漏
 * 2）其他程序无法将广播发送到我们程序的内部，因此也不用担心有什么安全漏洞的隐患
 * 3）发送本地广播比发送系统全局广播将会更高效
 *
 */
public class LocalBroadcastActivity extends AppCompatActivity {
    private LocalReceiver localReceiver;
    private LocalBroadcastManager localBroadcastManager;
    private IntentFilter intentFilter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_broadcast);
        localBroadcastManager = LocalBroadcastManager.getInstance(this);//获取实例
        intentFilter = new IntentFilter();
        intentFilter.addAction("com.rainy.broadcast.LOCAL_BROADCAST");
        //动态注册广播接收器，必须要在程序关闭的时候关掉广播
        localReceiver = new LocalReceiver();
        localBroadcastManager.registerReceiver(localReceiver,intentFilter);   //注册本地广播监听器



    }

    public void click(View v){
        Intent intent = new Intent("com.rainy.broadcast.LOCAL_BROADCAST");
        localBroadcastManager.sendBroadcast(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        localBroadcastManager.unregisterReceiver(localReceiver);
    }

    /**
     * 本地广播接收者
     */
    class LocalReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context,"receivered local broadcast",Toast.LENGTH_LONG).show();

        }
    }
}
