package com.example.home_gym;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.home_gym.Databse.DBHandler;
import com.example.home_gym.Models.ContactModel;

import java.util.ArrayList;

public class ContactList extends AppCompatActivity {

    ArrayList<ContactModel> ContactDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);

        DBHandler dbHandler = new DBHandler(this);
        ContactDetails = dbHandler.getAllLContactDetails();

    }
}