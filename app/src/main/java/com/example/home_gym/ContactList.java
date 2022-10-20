package com.example.home_gym;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.home_gym.Adapters.ContactAdapter;
import com.example.home_gym.Databse.DBHandler;
import com.example.home_gym.Models.ContactModel;

import java.util.ArrayList;

public class ContactList extends AppCompatActivity {

    TextView tvTotal;
    RecyclerView recyclerView;
    ContactAdapter contactAdapter;
    ArrayList<ContactModel> ContactDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);

        recyclerView = findViewById(R.id.recyclerView);
        tvTotal =findViewById(R.id.tvTotal);

        DBHandler dbHandler = new DBHandler(this);

        ContactDetails = dbHandler.getAllLContactDetails();

        tvTotal.setText("Total Contacts :" + ContactDetails.size());

        contactAdapter = new ContactAdapter(ContactDetails,this);
        recyclerView.setAdapter(contactAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);


       // for (ContactModel con : ContactDetails)
        //{
          //  System.out.println(con.getName());
        //}

    }
}