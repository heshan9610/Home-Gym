package com.example.home_gym.Databse;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHandler extends SQLiteOpenHelper {

    private static int VERSION = 1;
    private static String DATABASE_NAME = "HomeGym.db";

    //Lower body Table (Heshan Siriwardana)
    private static final String LOWERBODY_TABLE_NAME = "HomeGym_LowerBody";
    private static final String LOWERBODY_ID = "LowerBody_Id";
    private static final String LOWERBODY_DAY = "LowerBody_Day";
    private static final String LOWERBODY_PROCEDURE = "LowerBody_Procedure";
    private static final String LOWERBODY_TIMINGDURATION = "LowerBody_TimingDuration";
    private static final String LOWERBODY_BENEFITS = "LowerBody_Benefits";


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

        //Odara's Function Table Create Query

        //Ravishani's Function Table Create Query

        //--------------------------------------------

        //Heshan's Execute Query
        sqLiteDatabase.execSQL(TABLE_CREATE_LOWERBODY);

        //Suran's Execute Query

        //Odara's Execute Query

        //Ravishani's Execute Query

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        //Heshan's Drop Table Query
        //Suran's Drop Table Query
        //Odara's Drop Table Query
        //Ravishani's Drop Table Query
    }

    //Suran's Function CRUD
    //HEshan's Function CRUD
    //Odara's Function CRUD
    //Ravishani's Function CRUD


}
