package com.example.home_gym;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.home_gym.Databse.DBHandler;
import com.example.home_gym.Models.LowerBodyModel;

public class AddLowerBodyWorkout extends AppCompatActivity {

    //edit text fields added
    EditText lowerBodyDay, lowerBodyProcedure, lowerBodyDuration, lowerBodyBenefits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_lower_body_workout);

        lowerBodyDay = findViewById(R.id.lowerBodyDay);
        lowerBodyProcedure = findViewById(R.id.lowerBodyProcedure);
        lowerBodyDuration = findViewById(R.id.lowerBodyDuration);
        lowerBodyBenefits = findViewById(R.id.lowerBodyBenefits);

    }

    public void insertLowerBodyWorkout(View view){
        String day = lowerBodyDay.getText().toString().trim();
        String procedure = lowerBodyProcedure.getText().toString().trim();
        String duration = lowerBodyDuration.getText().toString().trim();
        String benefits = lowerBodyBenefits.getText().toString().trim();

        DBHandler dbHandler = new DBHandler(AddLowerBodyWorkout.this);

        LowerBodyModel lowerBodyModel = new LowerBodyModel(day, procedure, duration, benefits);

        long result = dbHandler.InsertLowerBodyWorkout(lowerBodyModel);

        if(result > 0){
            Toast.makeText(this, "Train Saved", Toast.LENGTH_SHORT).show();
            //dataSavedToast.show();
        }else {
            Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();
        }

    }
}