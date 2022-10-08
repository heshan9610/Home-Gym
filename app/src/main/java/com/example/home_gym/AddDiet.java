package com.example.home_gym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.home_gym.Databse.DBHandler;
import com.example.home_gym.Models.DietModel;

public class AddDiet extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText edDietTime, edDietDate, edDietBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_diet);

        edDietTime = findViewById(R.id.edDietTime);
        edDietDate = findViewById(R.id.edDietDate);
        edDietBody = findViewById(R.id.edDietBody);

        Spinner dietName = findViewById(R.id.dietName);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.dietNames, android.R.layout.simple_spinner_item );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dietName.setAdapter(adapter);
        dietName.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(adapterView.getContext(),text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        startActivity(new Intent(AddDiet.this, DietList.class));
    }

    public void SaveDiet(View view) {
        String dietTime = edDietTime.getText().toString().toString();
        String dietDate = edDietDate.getText().toString().toString();
        String dietBody = edDietBody.getText().toString().toString();

        DBHandler DbHandler = new DBHandler(AddDiet.this);

        DietModel DM = new DietModel(dietTime, dietDate, dietBody);

        long result = DbHandler.AddDiet(DM);
        
        if(result > 0){
            Toast.makeText(this, "Saved Successfully", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();
        }
    }

    public void ViewDietPlans(View view) {
    }
}