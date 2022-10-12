package com.example.home_gym.Databse;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.home_gym.Models.LowerBodyModel;

import java.util.ArrayList;

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
        String DROP_LOWERBODY_QUERY = " DROP TABLE IF EXISTS " + LOWERBODY_TABLE_NAME;

        //Suran's Drop Table Query
        //Odara's Drop Table Query
        //Ravishani's Drop Table Query

        //drop the lowerbody table
        sqLiteDatabase.execSQL(DROP_LOWERBODY_QUERY);

        //create table again
        onCreate(sqLiteDatabase);
    }

    //Suran's Function CRUD
    //HEshan's Function CRUD

    //LowerBody Function-------------------------------------------------------------------------------------------

    //Insert Lower Body workout to the table
    public long InsertLowerBodyWorkout(LowerBodyModel lowerBodyModel) {

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(LOWERBODY_DAY,lowerBodyModel.getWorkoutDay());
        contentValues.put(LOWERBODY_PROCEDURE,lowerBodyModel.getProcedure());
        contentValues.put(LOWERBODY_TIMINGDURATION,lowerBodyModel.getDuration());
        contentValues.put(LOWERBODY_BENEFITS,lowerBodyModel.getBenefits());

        long result = sqLiteDatabase.insert(LOWERBODY_TABLE_NAME, null, contentValues);

        return result;
    }


    //Display Lower Body workouts
    public ArrayList<LowerBodyModel> getAllLowerBodyDetails(){

        ArrayList<LowerBodyModel> lowerBodyDetails = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        String GET_DATA_QUERY = " SELECT * FROM " + LOWERBODY_TABLE_NAME;

        Cursor cursor = null;

        cursor = sqLiteDatabase.rawQuery(GET_DATA_QUERY, null);

        if( cursor.moveToFirst()){

            do{
                //row data
                int id = cursor.getInt(0);
                String workoutDay = cursor.getString(1);
                String workoutProcedure = cursor.getString(2);
                String workoutDuration= cursor.getString(3);
                String workoutBenefits= cursor.getString(4);

                LowerBodyModel lowerBodyModel= new LowerBodyModel(id, workoutDay, workoutProcedure,workoutDuration, workoutBenefits);
                lowerBodyDetails.add(lowerBodyModel);

            }while(cursor.moveToNext());

        }

        return lowerBodyDetails;
    }


    //Odara's Function CRUD
    //Ravishani's Function CRUD


}
