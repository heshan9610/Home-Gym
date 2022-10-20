package com.example.home_gym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AddUpperBodyWorkouts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_upper_body_workouts);
    }

    public void Save(View view) {
        startActivity(new Intent(AddUpperBodyWorkouts.this,EditUpperBodyWorkouts.class));

    }
}