package com.example.home_gym.Databse;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHandler extends SQLiteOpenHelper {

    private static int VERSION = 1;
    private static String DATABASE_NAME = "HomeGym.db";

    //Diet Table (Suran Sandeepa)
    private static final String DIET_TABLE_NAME = "HomeGym_Diet";
    private static final String DIET_ID = "Diet_Id";
    private static final String DIET_NAME = "Diet_Name";
    private static final String DIET_TIME = "Diet_Time";
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
                + DIET_TIME + " TEXT, "
                + DIET_DESCRIPTION + " TEXT" +
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

    //Suran's Function CRUD

    //---------------------------------------------------------------------------------
    //HEshan's Function CRUD

    //Odara's Function CRUD

    //Ravishani's Function CRUD


}
