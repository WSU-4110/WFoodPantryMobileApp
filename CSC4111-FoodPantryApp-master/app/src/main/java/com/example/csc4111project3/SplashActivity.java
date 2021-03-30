package com.example.csc4111project3;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity{
    Handler handler;
    SplashActivity i;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000);

    }

    private SplashActivity() {
        this.i = null;
    }

    public SplashActivity getSplashActivity(){
        if (i == null)
            i = new SplashActivity();

        return i;
    }
}
