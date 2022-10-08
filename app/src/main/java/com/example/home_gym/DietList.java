package com.example.home_gym;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.home_gym.Databse.DBHandler;
import com.example.home_gym.Models.DietModel;

import java.util.ArrayList;

public class DietList extends AppCompatActivity {

    ArrayList<DietModel>DietPlans;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet_list);

        DBHandler dbHandler = new DBHandler(this);

        DietPlans = dbHandler.getAllDietPlans();
    }
}