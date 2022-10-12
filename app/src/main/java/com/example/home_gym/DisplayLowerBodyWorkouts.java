package com.example.home_gym;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.home_gym.Databse.DBHandler;
import com.example.home_gym.Models.LowerBodyModel;

import java.util.ArrayList;

public class DisplayLowerBodyWorkouts extends AppCompatActivity {

    DBHandler dbHandler;
    RecyclerView recyclerView;
    TextView totalTrains;
    ArrayList<LowerBodyModel> lowerBodyDetails;
    TrainAdapter trainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_lower_body_workouts);
    }
}