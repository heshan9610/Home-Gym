package com.example.home_gym;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.home_gym.Adapters.LowerBodyAdapter;
import com.example.home_gym.Databse.DBHandler;
import com.example.home_gym.Models.LowerBodyModel;

import java.util.ArrayList;

public class DisplayLowerBodyWorkouts extends AppCompatActivity {

    DBHandler dbHandler;
    RecyclerView recyclerView;
    TextView totalLowerBodyWorkouts;
    ArrayList<LowerBodyModel> lowerBodyDetails;
    LowerBodyAdapter lowerBodyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_lower_body_workouts);

        totalLowerBodyWorkouts = findViewById(R.id.totalLowerBodyWorkouts);
        recyclerView = findViewById(R.id.recycleViewLowerBody);

        dbHandler = new DBHandler(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        lowerBodyDetails = dbHandler.getAllLowerBodyDetails();

        totalLowerBodyWorkouts.setText("Total Workouts : " + lowerBodyDetails.size());

        lowerBodyAdapter = new LowerBodyAdapter(lowerBodyDetails,this);
        recyclerView.setAdapter(lowerBodyAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
    }
}