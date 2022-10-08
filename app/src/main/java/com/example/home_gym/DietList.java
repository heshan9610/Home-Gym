package com.example.home_gym;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.home_gym.Databse.DBHandler;
import com.example.home_gym.Models.DietModel;

import java.util.ArrayList;

public class DietList extends AppCompatActivity {

    ArrayList<DietModel>DietPlans;
    RecyclerView recyclerView;
    TextView TotalDiets;
    DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet_list);

        TotalDiets = findViewById(R.id.DietPlanTotal);
        recyclerView = findViewById(R.id.dietRecycleView);

        dbHandler = new DBHandler(this);

        DietPlans = dbHandler.getAllDietPlans();
    }

    @Override
    protected void onStart() {
        super.onStart();

        DietPlans = dbHandler.getAllDietPlans();

        //get total timetable size
        TotalDiets.setText("Total Diet Plans : " + DietPlans.size());
    }
}