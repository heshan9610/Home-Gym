package com.example.home_gym;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.home_gym.Adapters.UpperBodyAdapter;
import com.example.home_gym.Databse.DBHandler;
import com.example.home_gym.Models.UpperBodyModel;

import java.util.ArrayList;

public class UpperWorkoutList extends AppCompatActivity {

    ArrayList<UpperBodyModel> upperBodyDetails;
    DBHandler dbHandler;
    RecyclerView recyclerView;
    TextView totalUpperBodyWorkouts;
    UpperBodyAdapter upperBodyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upper_workout_list);


        totalUpperBodyWorkouts = findViewById(R.id.totalUpperBodyWorkouts);
        recyclerView = findViewById(R.id.recycleViewUpperBody);

        dbHandler = new DBHandler(this);

    }

    @Override
    protected void onResume() {
        super.onResume();

        upperBodyDetails = dbHandler.getAllUpperBodyDetails();
        for(UpperBodyModel temp  : upperBodyDetails){
        }

        totalUpperBodyWorkouts.setText("Total Workouts : " + upperBodyDetails.size());

        upperBodyAdapter = new UpperBodyAdapter(upperBodyDetails,this);
        recyclerView.setAdapter(upperBodyAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
    }
}