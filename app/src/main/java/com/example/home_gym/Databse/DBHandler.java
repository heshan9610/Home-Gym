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

        String TABLE_CREATE_ADD_CONTACT = "CREATE TABLE " + CONTACT_TABLE_NAME + " " +
                " ("
                + TRAINER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + TRAINER_NAME + " TEXT, "
                + TRAINER_QUALIFICATION + " TEXT, "
                + TRAINER_CONTACT_NUM + " TEXT, "
                + TRAINER_TIME + " TEXT" +

                ");";

        //--------------------------------------------

        //Heshan's Execute Query
        sqLiteDatabase.execSQL(TABLE_CREATE_LOWERBODY);

        //Suran's Execute Query
        sqLiteDatabase.execSQL(TABLE_CREATE_DIET);

        //Odara's Execute Query

        //Ravishani's Execute Query
        sqLiteDatabase.execSQL(TABLE_CREATE_ADD_CONTACT);
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

    //Contact insert Function

    public long InsertContact(ContactModel contactModel) {

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(TRAINER_NAME, contactModel.getName());
        contentValues.put(TRAINER_QUALIFICATION, contactModel.getQualification());
        contentValues.put(TRAINER_CONTACT_NUM, contactModel.getContactNum());
        contentValues.put(TRAINER_TIME, contactModel.getTime());

        long result = sqLiteDatabase.insert(CONTACT_TABLE_NAME, null, contentValues);

        return result;

    }
    //Diplay Contact list

    public ArrayList<ContactModel> getAllLContactDetails() {

        ArrayList<ContactModel> ContactDetails = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery(" SELECT * FROM " + CONTACT_TABLE_NAME, null);


        if (cursor.moveToFirst()) {

            do {
                //row data
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                String qualifications = cursor.getString(2);
                String contactno = cursor.getString(3);
                String time = cursor.getString(4);

                ContactModel contactModel = new ContactModel(id, name, qualifications, contactno, time);
                ContactDetails.add(contactModel);

            } while (cursor.moveToNext());

        }


        return ContactDetails;

    }
        //update contact details

    public int UpdateContact(ContactModel contactModel) {

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(TRAINER_NAME, contactModel.getName());
        contentValues.put(TRAINER_QUALIFICATION, contactModel.getQualification());
        contentValues.put(TRAINER_CONTACT_NUM, contactModel.getContactNum());
        contentValues.put(TRAINER_TIME, contactModel.getTime());

        int result = sqLiteDatabase.update(CONTACT_TABLE_NAME, contentValues, "TRAINER_ID=?", new String[]{String.valueOf(contactModel.getId())});

        return result;
    }

    //Delete function

    public int DeleteContact(int id) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        int result = sqLiteDatabase.delete(CONTACT_TABLE_NAME, "TRAINER_ID=?",new String[]{String.valueOf(id)});

        return result;


    }
}
