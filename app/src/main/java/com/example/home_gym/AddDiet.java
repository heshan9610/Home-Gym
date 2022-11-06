package com.example.home_gym;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.home_gym.Databse.DBHandler;
import com.example.home_gym.Models.DietModel;

import java.util.Calendar;
import java.util.Locale;

public class AddDiet extends AppCompatActivity {

    DBHandler dbHandler;
    EditText edDietTime, edDietDate, edDietBody, edMealOfDay;
    Button btnCalendar;
    int y, m, d; //For Calender
    int t1Hour, t1Minute, t2Hour, t2Minute;
    Toast dataSavedToast, dataDeleteToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_diet);

        edMealOfDay = findViewById(R.id.edMealOfDay);
        edDietBody = findViewById(R.id.edDietBody);
        edDietTime = findViewById(R.id.edDietTime);
        edDietDate = findViewById(R.id.edDietDate);

        final Calendar c = Calendar.getInstance();

        //Calendar View
        edDietDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                y = c.get(Calendar.YEAR);
                m = c.get(Calendar.MONTH);
                d = c.get(Calendar.DATE);

                DatePickerDialog DPD = new DatePickerDialog(AddDiet.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        edDietDate.setText(i + " /" + i1 + "/" + i2);
                    }
                },y, m, d);
                DPD.show();
            }
        });

    }

    //Time Picker
    public void popTimePicker(View view) {

        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {

                t1Hour = selectedHour;
                t1Minute = selectedMinute;

                edDietTime.setText(String.format(Locale.getDefault(), "%02d:%02d", t1Hour,t1Minute));

            }
        };

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, onTimeSetListener, t1Hour, t1Minute, true);

        timePickerDialog.setTitle("Select Time");
        timePickerDialog.show();
    }

    //Insert Function
    public void SaveDiet(View view) {

        String dietMealOfDay = edMealOfDay.getText().toString().toString();
        String dietBody = edDietBody.getText().toString().toString();
        String dietTime = edDietTime.getText().toString().toString();
        String dietDate = edDietDate.getText().toString().toString();

        DBHandler DbHandler = new DBHandler(AddDiet.this);

        DietModel DM = new DietModel(dietMealOfDay, dietBody, dietDate, dietTime);

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