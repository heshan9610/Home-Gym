package com.example.home_gym;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.home_gym.Databse.DBHandler;
import com.example.home_gym.Models.UpperBodyModel;

public class EditUpperBodyWorkouts extends AppCompatActivity {

    EditText upperBodyDay, upperBodyProcedure, upperBodyDuration, upperBodyBenefits, upperBodyVideolink;
    int upperBodyId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_upper_body_workouts);

        UpperBodyModel upperBodyModel = (UpperBodyModel) getIntent().getExtras().getSerializable("UpperBodyModel");

        upperBodyDay = findViewById(R.id.updateUpperBodyDay);
        upperBodyProcedure = findViewById(R.id.updateUpperBodyProcedure);
        upperBodyDuration = findViewById(R.id.updateUpperBodyDuration);
        upperBodyBenefits = findViewById(R.id.updateUpperBodyBenefits);
        upperBodyVideolink = findViewById(R.id.updateUpperBodyTutorialLink);
        upperBodyId = upperBodyModel.getuppid();

        upperBodyDay.setText(upperBodyModel.getupperworkoutDay());
        upperBodyProcedure.setText(upperBodyModel.getupperprocedure());
        upperBodyDuration.setText(upperBodyModel.getupperduration());
        upperBodyBenefits.setText(upperBodyModel.getupperbenefits());
        upperBodyVideolink.setText(upperBodyModel.getuppertutoriallinks());

    }

    public void updateUpperBodyWorkout(View view) {

        String day = upperBodyDay.getText().toString().trim();
        String procedure = upperBodyProcedure.getText().toString().trim();
        String duration = upperBodyDuration.getText().toString().trim();
        String benefits = upperBodyBenefits.getText().toString().trim();
        String videoLink = upperBodyVideolink.getText().toString().trim();

        UpperBodyModel upperBodyModel = new UpperBodyModel(upperBodyId, day, procedure, duration, benefits, videoLink);

        DBHandler dbHandler = new DBHandler(this);

        int result = dbHandler.UpdateUpperBodyWorkout(upperBodyModel);

        if(result > 0){
            Toast.makeText(this, "Upper Body workout Updated", Toast.LENGTH_SHORT).show();
//            dataUpdateToast.show();
            finish();
        }else {
            Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();
        }
    }

}