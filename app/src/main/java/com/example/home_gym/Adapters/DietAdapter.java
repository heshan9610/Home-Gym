package com.example.home_gym.Adapters;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import com.example.home_gym.Models.DietModel;

import java.util.ArrayList;

public class DietAdapter {

    ArrayList<DietModel> diets;
    Context context;

    public DietAdapter(ArrayList<DietModel>diets, Context context){
        this.diets = diets;
        this.context = context;
    }

}
