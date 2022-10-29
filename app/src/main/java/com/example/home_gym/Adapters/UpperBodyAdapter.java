package com.example.home_gym.Adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.home_gym.Models.UpperBodyModel;
import com.example.home_gym.R;

import java.util.ArrayList;

public class UpperBodyAdapter extends RecyclerView.Adapter<UpperBodyAdapter.UpperBodyVH>{

    ArrayList<UpperBodyModel> upperBodyDetails;
    Context context;

    public UpperBodyAdapter(ArrayList<UpperBodyModel> upperBodyDetails, Context context) {
        this.upperBodyDetails = upperBodyDetails;
        this.context = context;
    }

    @NonNull
    @Override
    public UpperBodyVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.activity_one_upperbodyworkout, parent, false);
        UpperBodyVH upperBodyVH = new UpperBodyVH(view);
        return upperBodyVH;
    }

    @Override
    public void onBindViewHolder(@NonNull UpperBodyVH holder, int position) {

        final UpperBodyModel upperBodyModel = upperBodyDetails.get(position);
        holder.workoutDayUpperBody.setText(upperBodyModel.getupperworkoutDay());
        holder.procedureUpperBody.setText(upperBodyModel.getupperprocedure());
        holder.durationUpperBody.setText(upperBodyModel.getupperduration());
        holder.benefitsUpperBody.setText(upperBodyModel.getupperbenefits());
        holder.tutorialLinkUpperBody.setText(upperBodyModel.getuppertutoriallinks());

//        holder.CardUpdateRowDisplay.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent intent1 = new Intent(context, UpdateLowerBodyWorkout.class);
//                intent1.putExtra("LowerBodyModel", lowerBodyModel);
//                context.startActivity(intent1);
//            }
//        });

//        holder.CardDeleteRowDisplay.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                AlertDialog.Builder builder = new AlertDialog.Builder(context);
//
//                builder.setTitle("Confirmation!");
//                builder.setMessage("Are you sure to delete " + lowerBodyModel.getWorkoutDay() + " Workout  ?");
//                builder.setIcon(android.R.drawable.ic_menu_delete);
//                builder.setCancelable(false);
//
//                //Yes
//                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//
//                        DBHandler dbHandler = new DBHandler(context);
//
//                        int result = dbHandler.deleteLowerBodyWorkout(lowerBodyModel.getId());
//
//                        if(result > 0){
//                            Toast.makeText(context, "Deleted", Toast.LENGTH_SHORT).show();
//                            lowerBodyDetails.remove(lowerBodyModel);
//                            notifyDataSetChanged();
//                        }else {
//                            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });
//
//                //No
//                builder.setNegativeButton("No", null);
//                builder.show();
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return upperBodyDetails.size();
    }

    class UpperBodyVH extends RecyclerView.ViewHolder{

        TextView workoutDayUpperBody, procedureUpperBody, durationUpperBody, benefitsUpperBody, tutorialLinkUpperBody;
        CardView CardUpdateRowDisplay, CardDeleteRowDisplay;

        public UpperBodyVH(@NonNull View itemView) {
            super(itemView);

            workoutDayUpperBody = itemView.findViewById(R.id.workoutDayUpperBody);
            procedureUpperBody = itemView.findViewById(R.id.procedureUpperBody);
            durationUpperBody = itemView.findViewById(R.id.durationUpperBody);
            benefitsUpperBody = itemView.findViewById(R.id.benefitsUpperBody);
            tutorialLinkUpperBody = itemView.findViewById(R.id.tutorialVideoLinkUpperBody);

            CardUpdateRowDisplay = itemView.findViewById(R.id.CardUpdateRowDisplay);
            CardDeleteRowDisplay = itemView.findViewById(R.id.CardDeleteRowDisplay);

        }
    }


}