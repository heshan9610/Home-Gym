package com.example.home_gym;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.home_gym.Databse.DBHandler;
import com.example.home_gym.Models.ContactModel;

public class UpdateContact extends AppCompatActivity {
    EditText edName,edQualifications,edContactno,edTime;
    int contactId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_contact);

        ContactModel contactModel = (ContactModel) getIntent().getExtras().getSerializable("ContactModel");

        contactId = contactModel.getId();
        edName= findViewById(R.id.edName);
        edQualifications = findViewById(R.id.edQualifications);
        edContactno = findViewById(R.id.edContactno);
        edTime = findViewById(R.id.edTime);

        edName.setText(contactModel.getName());
        edQualifications.setText(contactModel.getQualification());
        edContactno .setText(contactModel.getContactNum());
        edTime .setText(contactModel.getTime());
    }


    public void update(View view){
        String name = edName.getText().toString().trim();
        String qualifications = edQualifications.getText().toString().trim();
        String contactno = edContactno.getText().toString().trim();
        String time = edTime.getText().toString().trim();

        ContactModel contactModel = new ContactModel(contactId, name, qualifications, contactno, time);

        DBHandler dbHandler = new DBHandler(this);

        int result = dbHandler.UpdateContact (contactModel);

        if(result > 0){
            Toast.makeText(this, "Contact Updated", Toast.LENGTH_SHORT).show();
//            dataUpdateToast.show();
            finish();
        }else {
            Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();
        }


    }
}