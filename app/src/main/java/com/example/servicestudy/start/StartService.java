package com.example.servicestudy.start;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class StartService extends Service {

    /**
     * 必须要实现的方式
     * bindService()绑定服务的时候才会调用此方法
     */
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i("ruxing", "onBind()...");
        return null;
    }

    /**
     * 首次创建服务时调用的方法，系统将调用此方法来执行一次性设置程序。
     * 如果服务已在运行，则不会调用此方法，该方法只调用一次
     */
    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("ruxing", "onCreate()...");
    }

    /**
     * startService()启动服务的时候会调用此方法，
     * 一旦执行此方法，服务即会启动并可在后台无限期运行。
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("ruxing", "onStartCommand()...");
        if (intent != null) {
            String result = intent.getStringExtra("param");
            Log.i("ruxing", "启动组件传过来的数据==" + result);
        }
        return super.onStartCommand(intent, flags, startId);
    }

    /**
     * 当服务不再使用且将被销毁时，系统将调用此方法。
     * 服务应该实现此方法来清理所有资源
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("ruxing", "onDestroy()...");
    }
}
