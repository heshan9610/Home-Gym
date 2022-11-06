package com.example.home_gym.Databse;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;



import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {

    private static int VERSION = 1;
    private static String DATABASE_NAME = "HomeGym.db";


    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //Heshan's Function Table Create Query
        String TABLE_CREATE_LOWERBODY = "CREATE TABLE " + LOWERBODY_TABLE_NAME + " " +
                " ("
                + LOWERBODY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + LOWERBODY_DAY + " TEXT, "
                + LOWERBODY_PROCEDURE + " TEXT, "
                + LOWERBODY_TIMINGDURATION + " TEXT, "
                + LOWERBODY_BENEFITS + " TEXT" +
                ");";

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
        sqLiteDatabase.execSQL(TABLE_CREATE_LOWERBODY);

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


    //Odara's Function CRUD

    //Ravishani's Function CRUD


}
