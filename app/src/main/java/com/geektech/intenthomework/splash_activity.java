package com.geektech.intenthomework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.Menu;
import android.widget.ImageView;

public class splash_activity extends AppCompatActivity {

    Handler handler;
    ImageView splash;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_activity);
        splash=findViewById(R.id.splash);
        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(splash_activity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);
    }
}