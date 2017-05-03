package com.rainy.webviewproject.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.rainy.webviewproject.R;

/**
 * 广播测试
 * 方式：动态注册
 * 缺点：需要在程序启动后才能接收广播
 */
public class BroadastActivity extends AppCompatActivity {

    private IntentFilter intentFilter;
    private NetworkChangeReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadast);
        //接收系统广播，动态注册
//        intentFilter = new IntentFilter();
//        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
//        receiver = new NetworkChangeReceiver();
//        registerReceiver(receiver,intentFilter);

        //接收自定义广播，静态注册
    }

    public void click(View v){
        //因为发送广播是使用Intent进行传递的，因此还可以在Intent中携带一些数据传递给广播接收器
        //在清单文件中注册过的receiver都是静态注册，不需要在程序关闭的时候取消注册
        Intent intent = new Intent("com.rainy.webviewproject.broadcast.MY_BROADCAST");
//        sendBroadcast(intent);//发送的是标准广播，没有顺序，每一个注册了的广播接受者都会接收到该广播发出的广播消息
        sendOrderedBroadcast(intent,null);//发送有序广播，第一参数是intent，第二个参数是接收权限
        //有序广播发送的有先后顺序，而且前面的广播接受者可以将广播截断，以阻止其继续传播，可以给广播接受者设定优先级，
        //确定接收到广播的优先顺序

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //注意：动态注册的广播接收器一定要取消注册才行
        unregisterReceiver(receiver);//停掉广播
    }

    /**
     * 广播接受者
     */
    class NetworkChangeReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager connectionManage = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetworkInfo = connectionManage.getActiveNetworkInfo();
            if(activeNetworkInfo != null && activeNetworkInfo.isAvailable()){
                Toast.makeText(BroadastActivity.this, "网络可用", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(BroadastActivity.this, "网络不可用", Toast.LENGTH_SHORT).show();
            }

        }
    }
}
