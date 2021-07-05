package com.example.servicestudy.start;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.example.servicestudy.R;

public class StartServiceActivity extends Activity {

    private Button mBtnStart;
    private Button mBtnStop;

    private Intent intent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_service);

        mBtnStart=findViewById(R.id.btn_start);
        mBtnStop=findViewById(R.id.btn_stop);

        intent=new Intent(this, StartService.class);
        intent.putExtra("param","test");

        mBtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(intent);
            }
        });
        mBtnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(intent);
            }
        });
    }
}
