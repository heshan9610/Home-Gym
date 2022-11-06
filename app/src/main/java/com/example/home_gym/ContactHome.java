package com.example.home_gym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ContactHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_home);
    }

    //add new contact
    public void displayAddContact(View view) {
        startActivity(new Intent(ContactHome.this, AddContact.class));
    }

    //view available contacts
    public void displayContactList(View view) {
        startActivity(new Intent(ContactHome.this, ContactList.class));
    }

}