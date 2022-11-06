package com.example.home_gym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomePage extends AppCompatActivity {

    TextView btnDietHome, btnStopWatch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        btnDietHome =findViewById(R.id.dietHome);
        btnStopWatch =findViewById(R.id.btnStopWatch);

        btnDietHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dietHome = new Intent(HomePage.this, DietHome.class);
                startActivity(dietHome);
            }
        });

        btnStopWatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent stopWatch = new Intent(HomePage.this, StopWatch.class);
                startActivity(stopWatch);
            }
        });
    }
}