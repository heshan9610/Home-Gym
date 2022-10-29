package com.example.home_gym.Databse;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.home_gym.Models.UpperBodyModel;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper{


    private static int VERSION = 1;
    private static String DATABASE_NAME = "HomeGym.db";

    //Upper body Table (Odara Amrakoon)
    private static final String UPPERBODY_TABLE_NAME = "HomeGym_UpperBody";
    private static final String UPPERBODY_ID = "UpperBody_Id";
    private static final String UPPERBODY_DAY = "UpperBody_Day";
    private static final String UPPERBODY_PROCEDURE = "UpperBody_Procedure";
    private static final String UPPERBODY_BENEFITS = "UpperBody_Benefits";
    private static final String UPPERBODY_TIMINGDURATION = "UpperBody_TimingDuration";
    private static final String UPPERBODY_TUTORIALLINK = "UpperBody_TutorialLink";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        //Odara's Function Table Create Query

        String TABLE_CREATE_UPPERBODY = "CREATE TABLE " + UPPERBODY_TABLE_NAME + " " +
                " ("
                + UPPERBODY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + UPPERBODY_DAY + " TEXT, "
                + UPPERBODY_PROCEDURE + " TEXT, "
                + UPPERBODY_BENEFITS + " TEXT, "
                + UPPERBODY_TIMINGDURATION + " TEXT, "
                + UPPERBODY_TUTORIALLINK + " TEXT" +
                ");";

        //Heshan's Function Table Create Query

        //Ravishani's Function Table Create Query

        //Suran's Function Table Create Query


        //--------------------------------------------

        //Odara's Execute Query
        sqLiteDatabase.execSQL(TABLE_CREATE_UPPERBODY);

        //Ravishani's Execute Query

        //Heshan's Execute Query

        //Suran's Execute Query


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        //Odara's Drop Table Query
        String DROP_UPPERBODY_QUERY = " DROP TABLE IF EXISTS " + UPPERBODY_TABLE_NAME;

        //Ravishani's Drop Table Query
        //Heshan's Drop Table Query
        //Suran's Drop Table Query

  

        //drop the upper body table
        sqLiteDatabase.execSQL(DROP_UPPERBODY_QUERY);

        //create table again
        onCreate(sqLiteDatabase);
    }


    //Odara's Function CRUD

    //Upper Body Function-------------------------------------------------------------------------------------------

        //Insert Upper Body workout to the table
    public long InsertUpperBodyWorkout(UpperBodyModel UpperBodyModel) {
    SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(UPPERBODY_DAY,UpperBodyModel.getupperworkoutDay());
        contentValues.put(UPPERBODY_PROCEDURE,UpperBodyModel.getupperprocedure());
        contentValues.put(UPPERBODY_BENEFITS,UpperBodyModel.getupperbenefits());
        contentValues.put(UPPERBODY_TIMINGDURATION,UpperBodyModel.getupperduration());
        contentValues.put(UPPERBODY_TUTORIALLINK,UpperBodyModel.getuppertutoriallinks());

        //insert data inside database table
        //return sqLiteDatabase.insert(UPPERBODY_TABLE_NAME,null, contentValues);

        long results = sqLiteDatabase.insert(UPPERBODY_TABLE_NAME, null, contentValues);

        return results;

   }


      //Display Upper Body workouts
        public ArrayList<UpperBodyModel> getAllUpperBodyDetails(){

        ArrayList<UpperBodyModel> upperBodyDetails = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        String GET_DATA_QUERY = " SELECT * FROM " + UPPERBODY_TABLE_NAME;

        Cursor cursor = null;

        cursor = sqLiteDatabase.rawQuery(GET_DATA_QUERY, null);

        if( cursor.moveToFirst()){

            do{
                //row data
                int uppid = cursor.getInt(0);
                String upperworkoutDay = cursor.getString(1);
                String upperprocedure = cursor.getString(2);
                String upperbenefits= cursor.getString(3);
                String upperduration= cursor.getString(4);
                String uppertutoriallinks= cursor.getString(5);

                UpperBodyModel upperBodyModel= new UpperBodyModel(uppid, upperworkoutDay, upperprocedure,upperbenefits, upperduration, uppertutoriallinks);
                upperBodyDetails.add(upperBodyModel);

            }while(cursor.moveToNext());

        }

        return upperBodyDetails;
    }

//    //Delete Lower Body workout
//    public int deleteLowerBodyWorkout(int id) {
//
//        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
//
//        int result = sqLiteDatabase.delete(UPPERBODY_TABLE_NAME, "UPPERBODY_ID=?",new String[]{String.valueOf(id)});
//
//        return result;
//    }
    //Ravishani's Function CRUD

    //HEshan's Function CRUD

    //Suran's Function CRUD


}

