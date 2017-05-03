package com.rainy.webviewproject.testjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.rainy.webviewproject.R;

import java.io.File;
import java.io.IOException;
import java.io.StreamCorruptedException;

public class MainTestActivity extends AppCompatActivity {
    private static final String TAG = "MainTestActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_test);
        TextView show = (TextView)findViewById(R.id.textShowTV);
        for (int i = 0; i < 100; i++) {
            Log.d(TAG, "onCreate: "+Thread.currentThread().getName()+"--------------"+i);
        }
        Thread t1 = new Thread(){
            @Override
            public void run() {
                super.run();
                for (int i = 0; i < 100; i++) {
                    Log.d(TAG, "run: ==t1"+Thread.currentThread().getName()+"-------------"+i);
                }
            }
        };
        t1.start();
        Thread t2 = new Thread(){
            @Override
            public void run() {
                super.run();
                for (int i = 0; i < 100; i++) {

                    Log.d(TAG, "run: ==t2"+Thread.currentThread().getName()+"---------------"+i);
                }
            }
        };
        t2.start();
        Thread t3 = new Thread(){
            @Override
            public void run() {
                super.run();
                for (int i = 0; i < 100; i++) {
                    Log.d(TAG, "run: ==t3"+Thread.currentThread().getName()+"-----------"+i);
                }
            }
        };
        t3.start();

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                aboutFile();
            }
        });

    }

    /**
     * 文件相关的用法
     */
    public void aboutFile(){
        //创建File对象有三种方式
        //方式1
        File file1 = new File("d:\\dddddddddddddddddemo.txt");
        if(file1.exists()){
            Log.d(TAG, "aboutFile: 存在");
        }else {
            try {
                boolean newFile = file1.createNewFile();
                Log.d(TAG, "aboutFile: 不存在"+newFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
//            boolean mkdir = file1.mkdir();
        }
        //方式2
//        File file2 = new File("d:/","demo1.txt");
//        //方式3
//        File dir = new File("d:/wenjianjia");
//        File file3 = new File(dir,"demo2.txt");
//
//        //给定一个字符串“d:/demo/111”
//        String dir1 = "d:/demo/111";
//        File file4 = new File(dir1+"demo.txt");

    }
}
