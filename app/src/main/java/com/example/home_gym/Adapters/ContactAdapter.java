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

import com.example.home_gym.Models.ContactModel;
import com.example.home_gym.R;
import com.example.home_gym.UpdateContact;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactVH> {


    ArrayList<ContactModel> ContactDetails;
    Context context;

    public ContactAdapter(ArrayList<ContactModel> ContactDetails, Context context) {
        this.ContactDetails= ContactDetails;
        this.context = context;
    }

    @NonNull
    @Override
    public ContactVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.one_contact, parent, false);
        ContactVH contactVH = new ContactVH(view);
        return contactVH;

    }

    @Override
    public void onBindViewHolder(@NonNull ContactVH holder, int position) {

        final ContactModel contactModel = ContactDetails.get(position);
        holder.tvName.setText(contactModel.getName());
        holder.tvQualifications.setText(contactModel.getQualification());
        holder.tvContactno.setText(contactModel.getContactNum());
        holder.tvTime.setText(contactModel.getTime());

        holder.concardUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(context, contactModel.getName() +" will be updated", Toast.LENGTH_SHORT).show();
                Intent intent01 = new Intent(context, UpdateContact.class);
                intent01.putExtra("ContactModel", contactModel);
                context.startActivity(intent01);
            }
        });

        holder.concardDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, contactModel.getName() +" will be deleted", Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return ContactDetails.size();
    }


    class ContactVH extends RecyclerView.ViewHolder{

        TextView tvName, tvQualifications, tvContactno, tvTime;
        CardView concardUpdate, concardDelete;

        public ContactVH(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            tvQualifications = itemView.findViewById(R.id.tvQualifications);
            tvContactno = itemView.findViewById(R.id.tvContactno);
            tvTime = itemView.findViewById(R.id.tvTime);

            concardUpdate = itemView.findViewById(R.id.concardUpdate);
            concardDelete = itemView.findViewById(R.id.concardDelete);

        }
    }
}