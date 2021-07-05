package com.example.servicestudy.bind;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.example.servicestudy.R;

public class BindServiceActivity extends Activity {

    private Button mBtnBind;
    private Button mBtnUnbind;
    private Button mBtnGetServiceData;

    private Conn conn;
    private BindService mService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bind_service);

        mBtnBind = findViewById(R.id.btn_bind);
        mBtnUnbind = findViewById(R.id.btn_unbind);
        mBtnGetServiceData=findViewById(R.id.btn_get_service_data);
        mBtnBind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BindServiceActivity.this, BindService.class);
                intent.putExtra("param", "testtesttest");
                bindService(intent, conn, Context.BIND_AUTO_CREATE);
            }
        });
        mBtnUnbind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unbindService(conn);
            }
        });
        mBtnGetServiceData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //如果绑定服务成功，调用服务的方法获取数据
                if (mService != null) {
                    String data = mService.getData();
                    Log.i("ruxing", "调用服务的方法获取到的数据=" + data);
                }
            }
        });
        conn = new Conn();
    }

    private class Conn implements ServiceConnection {

        /**
         * 绑定服务成功的监听，service是服务绑定成功后的返回值，即onBind()方法的返回值
         */
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.i("ruxing", "绑定服务成功...");
            BindService.MyBind binder = (BindService.MyBind) service;
            mService = binder.getService();
        }

        /**
         * 因为异常取消绑定的时候调用
         */
        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.i("ruxing", "绑定服务失败。。。");
            mService = null;
        }
    }
}
