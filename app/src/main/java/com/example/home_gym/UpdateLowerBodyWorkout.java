package com.example.home_gym;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.home_gym.Databse.DBHandler;
import com.example.home_gym.Models.LowerBodyModel;

public class UpdateLowerBodyWorkout extends AppCompatActivity {

    EditText lowerBodyDay, lowerBodyProcedure, lowerBodyDuration, lowerBodyBenefits;
    int lowerBodyId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_lower_body_workout);

        LowerBodyModel lowerBodyModel = (LowerBodyModel) getIntent().getExtras().getSerializable("LowerBodyModel");

        lowerBodyDay = findViewById(R.id.updateLowerBodyDay);
        lowerBodyProcedure = findViewById(R.id.updateLowerBodyProcedure);
        lowerBodyDuration = findViewById(R.id.updateLowerBodyDuration);
        lowerBodyBenefits = findViewById(R.id.updateLowerBodyBenefits);
        lowerBodyId = lowerBodyModel.getId();

        lowerBodyDay.setText(lowerBodyModel.getWorkoutDay());
        lowerBodyProcedure.setText(lowerBodyModel.getProcedure());
        lowerBodyDuration.setText(lowerBodyModel.getDuration());
        lowerBodyBenefits.setText(lowerBodyModel.getBenefits());

    }

    public void updateLowerBodyWorkout(View view) {

        String day = lowerBodyDay.getText().toString().trim();
        String procedure = lowerBodyProcedure.getText().toString().trim();
        String duration = lowerBodyDuration.getText().toString().trim();
        String benefits = lowerBodyBenefits.getText().toString().trim();

        LowerBodyModel lowerBodyModel = new LowerBodyModel(lowerBodyId, day, procedure, duration, benefits);

        DBHandler dbHandler = new DBHandler(this);

        int result = dbHandler.UpdateLowerBodyWorkout(lowerBodyModel);

        if(result > 0){
            Toast.makeText(this, "Lower Body workout Updated", Toast.LENGTH_SHORT).show();
//            dataUpdateToast.show();
            finish();
        }else {
            Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();
        }
    }

}