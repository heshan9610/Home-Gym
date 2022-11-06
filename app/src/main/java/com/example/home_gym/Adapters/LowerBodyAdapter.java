package com.example.home_gym.Adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.home_gym.Databse.DBHandler;
import com.example.home_gym.Models.LowerBodyModel;
import com.example.home_gym.R;
import com.example.home_gym.UpdateLowerBodyWorkout;

import java.util.ArrayList;

public class LowerBodyAdapter extends RecyclerView.Adapter<LowerBodyAdapter.LowerBodyVH>{

    ArrayList<LowerBodyModel> lowerBodyDetails;
    Context context;

    public LowerBodyAdapter(ArrayList<LowerBodyModel> lowerBodyDetails, Context context) {
        this.lowerBodyDetails = lowerBodyDetails;
        this.context = context;
    }

    @NonNull
    @Override
    public LowerBodyVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.one_lowerbodyworkout, parent, false);
        LowerBodyVH lowerBodyVH = new LowerBodyVH(view);
        return lowerBodyVH;
    }

    @Override
    public void onBindViewHolder(@NonNull LowerBodyVH holder, int position) {

        final LowerBodyModel lowerBodyModel = lowerBodyDetails.get(position);
        holder.workoutDayLowerBody.setText(lowerBodyModel.getWorkoutDay());
        holder.procedureLowerBody.setText(lowerBodyModel.getProcedure());
        holder.durationLowerBody.setText(lowerBodyModel.getDuration());
        holder.benefitsLowerBody.setText(lowerBodyModel.getBenefits());

        holder.CardUpdateRowDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent1 = new Intent(context, UpdateLowerBodyWorkout.class);
                intent1.putExtra("LowerBodyModel", lowerBodyModel);
                context.startActivity(intent1);
            }
        });

        holder.CardDeleteRowDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(context);

                builder.setTitle("Confirmation!");
                builder.setMessage("Are you sure to delete " + lowerBodyModel.getWorkoutDay() + " Workout  ?");
                builder.setIcon(android.R.drawable.ic_menu_delete);
                builder.setCancelable(false);

                //Yes
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        DBHandler dbHandler = new DBHandler(context);

                        int result = dbHandler.deleteLowerBodyWorkout(lowerBodyModel.getId());

                        if(result > 0){
                            Toast.makeText(context, "Deleted", Toast.LENGTH_SHORT).show();
                            lowerBodyDetails.remove(lowerBodyModel);
                            notifyDataSetChanged();
                        }else {
                            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                //No
                builder.setNegativeButton("No", null);
                builder.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return lowerBodyDetails.size();
    }

    class LowerBodyVH extends RecyclerView.ViewHolder{

        TextView workoutDayLowerBody, procedureLowerBody, durationLowerBody, benefitsLowerBody;
        CardView CardUpdateRowDisplay, CardDeleteRowDisplay;

        public LowerBodyVH(@NonNull View itemView) {
            super(itemView);

            workoutDayLowerBody = itemView.findViewById(R.id.workoutDayLowerBody);
            procedureLowerBody = itemView.findViewById(R.id.procedureLowerBody);
            durationLowerBody = itemView.findViewById(R.id.durationLowerBody);
            benefitsLowerBody = itemView.findViewById(R.id.benefitsLowerBody);

            CardUpdateRowDisplay = itemView.findViewById(R.id.CardUpdateRowDisplay);
            CardDeleteRowDisplay = itemView.findViewById(R.id.CardDeleteRowDisplay);

        }
    }


}
