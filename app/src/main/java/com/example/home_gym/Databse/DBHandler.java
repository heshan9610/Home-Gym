package com.example.home_gym.Databse;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHandler extends SQLiteOpenHelper {

    private static int VERSION = 1;
    private static String DATABASE_NAME = "HomeGym.db";

    //contact table coulumn values

    private static final String CONTACT_TABLE_NAME = "contact";
    private static final String TRAINER_ID = "trainer_id";
    private static final String TRAINER_NAME = "trainer_name";
    private static final String TRAINER_QUALIFICATION = "trainer_qualification";
    private static final String  TRAINER_CONTACT_NUM= "trainer_contact_num";
    private static final String TRAINER_TIME = "trainer_time";


    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //Heshan's Function Table Create Query

        //Suran's Function Table Create Query

        //Odara's Function Table Create Query

        //Ravishani's Function Table Create Query

        String TABLE_CREATE_ADD_CONTACT = "CREATE TABLE " + CONTACT_TABLE_NAME + " "+
                " ("
                + TRAINER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + TRAINER_NAME + " TEXT, "
                +TRAINER_QUALIFICATION + " TEXT, "
                +TRAINER_CONTACT_NUM + " TEXT, "
                + TRAINER_TIME + " TEXT"+

                ");";

        //--------------------------------------------

        //Heshan's Execute Query

        //Suran's Execute Query

        //Odara's Execute Query

        //Ravishani's Execute Query
        sqLiteDatabase.execSQL(TABLE_CREATE_ADD_CONTACT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        //Heshan's Drop Table Query
        //Suran's Drop Table Query
        //Odara's Drop Table Query
        //Ravishani's Drop Table Query
        String DROP_CONTACT_QUERY = " DROP TABLE IF EXISTS " + CONTACT_TABLE_NAME;
        sqLiteDatabase.execSQL(DROP_CONTACT_QUERY);
        onCreate(sqLiteDatabase);
    }

    //Suran's Function CRUD
    //HEshan's Function CRUD
    //Odara's Function CRUD
    //Ravishani's Function CRUD


}
