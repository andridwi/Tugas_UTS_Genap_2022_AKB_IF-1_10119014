package com.example.a10119014_andridwip;
// Nama : Andri Dwi P
//NIM : 10119014
//kelas: IF-1

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent i = new Intent (SplashScreen.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        },5000);
    }
}