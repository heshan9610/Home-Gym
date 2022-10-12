package com.example.home_gym.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.home_gym.Models.LowerBodyModel;
import com.example.home_gym.R;

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

        LowerBodyModel lowerBodyModel = lowerBodyDetails.get(position);
        holder.workoutDayLowerBody.setText(lowerBodyModel.getWorkoutDay());
        holder.procedureLowerBody.setText(lowerBodyModel.getProcedure());
        holder.durationLowerBody.setText(lowerBodyModel.getDuration());
        holder.benefitsLowerBody.setText(lowerBodyModel.getBenefits());


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
