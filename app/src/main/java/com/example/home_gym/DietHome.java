package com.example.home_gym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DietHome extends AppCompatActivity {

    Button btnAddDiet, btnDietPlans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet_home);

        btnAddDiet = findViewById(R.id.addDiet);
        btnDietPlans = findViewById(R.id.dietPlans);

        btnAddDiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addDiet = new Intent(DietHome.this, AddDiet.class);
                startActivity(addDiet);
            }
        });

    }
}