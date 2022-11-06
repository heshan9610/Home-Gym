package com.example.home_gym.Databse;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.home_gym.Models.DietModel;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {

    private static int VERSION = 1;
    private static String DATABASE_NAME = "HomeGym.db";

    //Diet Table (Suran Sandeepa)
    private static final String DIET_TABLE_NAME = "HomeGym_Diet";
    private static final String DIET_ID = "Diet_Id";
    private static final String DIET_NAME = "Diet_Name";
    private static final String DIET_TIME = "Diet_Time";
    private static final String DIET_DATE = "Diet_DATE";
    private static final String DIET_DESCRIPTION = "Diet_Description";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //Heshan's Function Table Create Query

        //Suran's Function Table Create Query
        String TABLE_CREATE_DIET = "CREATE TABLE " + DIET_TABLE_NAME + " " +
                " ("
                + DIET_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + DIET_NAME + " TEXT, "
                + DIET_DESCRIPTION + " TEXT, "
                + DIET_DATE + " TEXT, "
                + DIET_TIME + " TEXT" +
                ");";

        //Odara's Function Table Create Query

        //Ravishani's Function Table Create Query

        //--------------------------------------------

        //Heshan's Execute Query

        //Suran's Execute Query
        sqLiteDatabase.execSQL(TABLE_CREATE_DIET);

        //Odara's Execute Query

        //Ravishani's Execute Query

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        //Heshan's Drop Table Query

        //Suran's Drop Table Query
        String DROP_DIET_QUERY = " DROP TABLE IF EXISTS " + DIET_TABLE_NAME;

        //Odara's Drop Table Query

        //Ravishani's Drop Table Query

        sqLiteDatabase.execSQL(DROP_DIET_QUERY);

        //Create Table Again
        onCreate(sqLiteDatabase);
    }


    //Suran's Function CRUD-------------------------------------------------------------------------

    //Data Insert
    public long AddDiet(DietModel DM) {

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues contentValue = new ContentValues();

        //store all data and pass it to database table
        contentValue.put(DIET_NAME,DM.getdMealOfDay());
        contentValue.put(DIET_DESCRIPTION,DM.getdDescription());
        contentValue.put(DIET_DATE,DM.getdDate());
        contentValue.put(DIET_TIME,DM.getdTime());

        //insert data inside database table
        return sqLiteDatabase.insert(DIET_TABLE_NAME,null, contentValue);
    }

    //Display Diet List
    public ArrayList<DietModel>getAllDietPlans(){

        ArrayList<DietModel>DietPlans = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        //select * data from Diet Table
        String GET_DATA_QUERY = " SELECT * FROM " + DIET_TABLE_NAME;

        Cursor cursor = null; //Cursor OBJ

        //cursor obtain all data from db
        cursor = sqLiteDatabase.rawQuery(GET_DATA_QUERY, null);

        if(cursor.moveToNext()){ //first row
            do{
                //row data
                int id = cursor.getInt(0);
                String dName = cursor.getString(1);
                String dBody = cursor.getString(2);
                String dDate = cursor.getString(4);
                String dTime = cursor.getString(4);

                DietModel DM = new DietModel(id,dName, dBody, dDate, dTime);
                DietPlans.add(DM);

            }while(cursor.moveToNext()); // next row
        }

        return DietPlans;
    }

    public int UpdateDietPlan(DietModel dietModel) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues contentValue = new ContentValues();

        //store all data and pass it to database table
        contentValue.put(DIET_NAME,dietModel.getdMealOfDay());
        contentValue.put(DIET_DESCRIPTION,dietModel.getdDescription());
        contentValue.put(DIET_DATE,dietModel.getdDate());
        contentValue.put(DIET_TIME,dietModel.getdTime());

        return sqLiteDatabase.update(DIET_TABLE_NAME, contentValue, "Diet_Id=?", new String[]{String.valueOf(dietModel.getId())});

    }

    public int deleteDietPlan(int id) {

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        return sqLiteDatabase.delete(DIET_TABLE_NAME, "Diet_Id=?",new String[]{String.valueOf(id)});
    }

    //Heshan's Function CRUD

    //Odara's Function CRUD

    //Ravishani's Function CRUD


}
