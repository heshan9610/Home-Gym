package com.example.home_gym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LowerBodyHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lower_body_home);
    }

    public void displayAddLowerBodyWorkoutPage(View view) {
        startActivity(new Intent(LowerBodyHome.this, AddLowerBodyWorkout.class));
    }

    public void displayViewLowerBodyWorkoutPage(View view) {
        startActivity(new Intent(LowerBodyHome.this, ViewLowerBodyWorkout.class));
    }

}