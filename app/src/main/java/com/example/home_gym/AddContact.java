package com.example.home_gym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.home_gym.Databse.DBHandler;
import com.example.home_gym.Models.ContactModel;

public class AddContact extends AppCompatActivity {

    EditText edName,edQualifications,edContactno,edTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        edName= findViewById(R.id.edName);
        edQualifications = findViewById(R.id.edQualifications);
        edContactno = findViewById(R.id.edContactno);
        edTime = findViewById(R.id.edTime);
    }

    public void save(View view){

        String name = edName.getText().toString().trim();
        String qualifications = edQualifications.getText().toString().trim();
        String contactno = edContactno.getText().toString().trim();
        String time = edTime.getText().toString().trim();

        DBHandler dbHandler = new DBHandler(AddContact.this);

        ContactModel contactModel = new ContactModel(name,qualifications,contactno,time);

        long result = dbHandler.InsertContact(contactModel);

        if(result > 0){
            Toast.makeText(this, "Contact Saved", Toast.LENGTH_SHORT).show();
            //dataSavedToast.show();
        }else {
            Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();
        }

    }
}