package com.example.home_gym.Databse;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.home_gym.Models.ContactModel;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {

    private static int VERSION = 1;
    private static String DATABASE_NAME = "HomeGym.db";

    //contact table coulumn values

    private static final String CONTACT_TABLE_NAME = "contact";
    private static final String TRAINER_ID = "trainer_id";
    private static final String TRAINER_NAME = "trainer_name";
    private static final String TRAINER_QUALIFICATION = "trainer_qualification";
    private static final String TRAINER_CONTACT_NUM = "trainer_contact_num";
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

        //drop the contact table

        sqLiteDatabase.execSQL(DROP_CONTACT_QUERY);

        //create table again

        onCreate(sqLiteDatabase);
    }


    //Suran's Function CRUD
    //HEshan's Function CRUD
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
