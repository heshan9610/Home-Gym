package com.example.home_gym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class UpperBodyHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upper_body_home);
    }

    public void AddWorkout(View view) {
        startActivity(new Intent(UpperBodyHome.this, AddUpperBodyWorkouts.class));

    }

    public void UpperWorkoutList(View view) {
        startActivity(new Intent(UpperBodyHome.this, UpperWorkoutList.class));
    }
}