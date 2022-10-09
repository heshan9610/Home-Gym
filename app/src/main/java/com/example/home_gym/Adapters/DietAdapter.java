package com.example.home_gym.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.home_gym.Models.DietModel;
import com.example.home_gym.R;
import com.example.home_gym.UpdateDiet;

import java.util.ArrayList;

public class DietAdapter extends RecyclerView.Adapter<DietAdapter.DietVH>{

    ArrayList<DietModel> diets;
    Context context;

    public DietAdapter(ArrayList<DietModel> diets, Context context) {
        this.diets = diets;
        this.context = context;
    }

    @NonNull
    @Override
    public DietVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.raw_diet_plan,parent,false);
        DietVH dvh = new DietVH(view);

        return dvh;
    }

    @Override
    public void onBindViewHolder(@NonNull DietVH holder, int position) {

        final DietModel dietModel = diets.get(position);

        holder.tvTime.setText(dietModel.getdTime());
        holder.tvDate.setText(dietModel.getdDate());
        holder.tvBody.setText(dietModel.getdDescription());

        holder.cardUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent updateIntent = new Intent(context, UpdateDiet.class);
                updateIntent.putExtra("DIETS", dietModel);
                context.startActivity(updateIntent);
            }
        });

        holder.cardDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(context, dietModel.getdTime() + "Will Be Deleted", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return diets.size();
    }

    class DietVH extends RecyclerView.ViewHolder{

        TextView tvMeal, tvTime, tvDate, tvBody;
        CardView cardUpdate, cardDelete;

        public DietVH(@NonNull View view) {
            super(view);

            tvMeal = view.findViewById(R.id.tvMeal);
            tvTime = view.findViewById(R.id.tvTime);
            tvDate = view.findViewById(R.id.tvDate);
            tvBody = view.findViewById(R.id.tvBody);

            cardUpdate = view.findViewById(R.id.cardUpdate);
            cardDelete = view.findViewById(R.id.cardDelete);
        }
    }
}
