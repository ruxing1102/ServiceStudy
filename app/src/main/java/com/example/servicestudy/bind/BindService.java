package com.example.servicestudy.bind;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class BindService extends Service {

    int i = 0;

    /**
     * 创建Binder对象，返回给客户端(即Activity)使用，提供数据交换的接口
     */
    public class MyBind extends Binder {

        //声明一个方法，提供给客户端(Activity)调用
        public BindService getService() {
            //返回当前对象BindService，这样我们就可以在客户端(Activity)调用Service的公共方法了
            return BindService.this;
        }
    }

    /**
     * 公共方法
     */
    public String getData() {
        i++;
        return i + "";
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("ruxing", "onCreate()...");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i("ruxing", "onBind()...");
        if (intent != null) {
            String data = intent.getStringExtra("param");
            Log.i("ruxing", "启动组件传过来的数据=" + data);
        }
        //把Binder类返回给客户端
        return new MyBind();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i("ruxing", "onUnbind()...");
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        Log.i("ruxing", "onRebind()...");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("ruxing", "onDestroy()...");
    }
}
