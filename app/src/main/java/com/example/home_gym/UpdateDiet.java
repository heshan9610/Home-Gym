package com.example.home_gym;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.home_gym.Databse.DBHandler;
import com.example.home_gym.Models.DietModel;

import java.util.Calendar;
import java.util.Locale;

public class UpdateDiet extends AppCompatActivity {

    EditText edDietTime, edDietDate, edDietBody, edMealOfDay;
    int id;
    Button btnCalendar;
    int y, m, d; //For Calender
    int t1Hour, t1Minute, t2Hour, t2Minute;
    Toast dataSavedToast, dataDeleteToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_diet);

        DietModel dietModel = (DietModel) getIntent().getExtras().getSerializable("DIETS");

        id = dietModel.getId();

        edMealOfDay = findViewById(R.id.edMealOfDay);
        edDietBody = findViewById(R.id.edDietBody);
        edDietTime = findViewById(R.id.edDietTime);
        edDietDate = findViewById(R.id.edDietDate);

        edMealOfDay.setText(dietModel.getdMealOfDay());
        edDietTime.setText(dietModel.getdTime());
        edDietDate.setText(dietModel.getdDate());
        edDietBody.setText(dietModel.getdDescription());

        final Calendar c = Calendar.getInstance();

        //Calendar View
        edDietDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                y = c.get(Calendar.YEAR);
                m = c.get(Calendar.MONTH);
                d = c.get(Calendar.DATE);

                DatePickerDialog DPD = new DatePickerDialog(UpdateDiet.this, new DatePickerDialog.OnDateSetListener() {
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


    public void UpdateDiet(View view) {
        String dietName = edMealOfDay.getText().toString().toString();
        String dietDate = edDietDate.getText().toString().toString();
        String dietTime = edDietTime.getText().toString().toString();
        String dietBody = edDietBody.getText().toString().toString();

        DietModel dietModel = new DietModel(id,dietName,dietBody,dietDate, dietTime);

        DBHandler dbHandler = new DBHandler(this);
        int result = dbHandler.UpdateDietPlan(dietModel);

        if(result > 0){
            Toast.makeText(this, "Updated Successfully", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();
        }
    }
}
