package com.example.home_gym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomePage extends AppCompatActivity {

    TextView btnDietHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        btnDietHome =findViewById(R.id.dietHome);

        btnDietHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dietHome = new Intent(HomePage.this, DietHome.class);
                startActivity(dietHome);
            }
        });
    }
}