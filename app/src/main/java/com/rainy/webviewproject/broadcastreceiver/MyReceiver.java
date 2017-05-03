package com.rainy.webviewproject.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * 接收自己发送的标准广播接收器
 */
public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Toast.makeText(context,"接收自己发送的标准广播",Toast.LENGTH_SHORT).show();
//        throw new UnsupportedOperationException("Not yet implemented");
    }
}
