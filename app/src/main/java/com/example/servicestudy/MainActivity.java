package com.example.servicestudy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.servicestudy.bind.BindServiceActivity;
import com.example.servicestudy.start.StartService;
import com.example.servicestudy.start.StartServiceActivity;

public class MainActivity extends AppCompatActivity {

    private Button mBtnStart;
    private Button mBtnBind;

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnStart=findViewById(R.id.btn_start);
        mBtnBind=findViewById(R.id.btn_bind);

        intent=new Intent(this, StartService.class);
        intent.putExtra("param","test");

        mBtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, StartServiceActivity.class);
                startActivity(intent);
            }
        });
        mBtnBind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, BindServiceActivity.class);
                startActivity(intent);
            }
        });
    }
}