package com.example.home_gym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.home_gym.Databse.DBHandler;
import com.example.home_gym.Models.UpperBodyModel;

public class AddUpperBodyWorkouts extends AppCompatActivity {


    //edit text fields added

    EditText upperBodyDay, upperBodyProcedure, upperBodyBenefits, upperBodyDuration, upperBodyVideoLinks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_upper_body_workouts);



//        upperBodyDay = findViewById(R.id.upperBodyDay);
//        upperBodyProcedure = findViewById(R.id.upperBodyProcedure);
//        upperBodyBenefits = findViewById(R.id.upperBodyBenefits);
//        upperBodyDuration = findViewById(R.id.upperBodyDuration);
//        upperBodyVideoLinks = findViewById(R.id.upperBodyVideoLinks);
    }

//insert
    public void InsertUpperBodyWorkout(View view){
        String day = upperBodyDay.getText().toString().trim();
        String procedure = upperBodyProcedure.getText().toString().trim();
        String benefits = upperBodyDuration.getText().toString().trim();
        String duration = upperBodyBenefits.getText().toString().trim();
        String links = upperBodyVideoLinks.getText().toString().trim();


        //DBHandler dbHandler = new DBHandler(AddUpperBodyWorkout.this);

       UpperBodyModel UpperBodyModel = new UpperBodyModel(day, procedure, duration, benefits,links);

//        long result = dbHandler.InsertUpperBodyWorkout(UpperBodyModel);
//
//        if(result > 0){
//            Toast.makeText(this, "Lower Body workout Saved", Toast.LENGTH_SHORT).show();
//            //dataSavedToast.show();
//        }else {
//            Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();
//        }

    }


    public void Save(View view) {
        startActivity(new Intent(AddUpperBodyWorkouts.this,EditUpperBodyWorkouts.class));

    }
}