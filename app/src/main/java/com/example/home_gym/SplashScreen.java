package com.example.home_gym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Thread tread = new Thread(
                new Runnable() {
                    @Override
                    public void run() {

                        try {
                            Thread.sleep(5000);

                            startActivity(new Intent(SplashScreen.this, HomePage.class));

                            finish();

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );

        tread.start();
    }
}