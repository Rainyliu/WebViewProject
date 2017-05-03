package com.rainy.webviewproject.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.rainy.webviewproject.MainActivity;

/**
 * Author: Rainy <br>
 * Description: WebViewProject <br>静态注册实现开机启动
 * 静态注册时广播接收器一定要在清单文件中注册才可以
 * Since: 2017/2/8 0008 12:16 <br>
 */

public class BootCompleteReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"boot complete" ,Toast.LENGTH_SHORT).show();
//        Intent intent1 = new Intent(context, MainActivity.class);
//        intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        context.startActivity(intent1);
        //注意:不要在onreceiver（）中添加过多逻辑或者是进行任何的耗时操作，
        //因为广播接收器中是不允许开启线程的，当该方法运行很长时间没有结束的时候，
        //程序就会报错，一般都是用广播创建一条状态栏，或者是开启一个服务等
    }
}
