package com.parys.alex.friendsdatabase;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import java.util.List;


/**
 * Created by apary on 12/4/2017.
 */

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "contactsManager";

    // Contacts table name
    private static final String TABLE_FRIENDS = "friends";

    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_EMAIL = "email";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_FRIENDS_TABLE = "CREATE TABLE " + TABLE_FRIENDS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_EMAIL + " TEXT" + ")";
        db.execSQL(CREATE_FRIENDS_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FRIENDS);

        // Create tables again
        onCreate(db);
    }

    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */

    // Adding new friends
    void addFriends(Friends friends) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, friends.getName()); // Friend Name
        values.put(KEY_EMAIL, friends.getEmail()); // Friend Email

        // Inserting Row
        db.insert(TABLE_FRIENDS, null, values);
        db.close(); // Closing database connection
    }

    // Getting single contact
    Friends getFriends(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_FRIENDS, new String[] { KEY_ID,
                        KEY_NAME, KEY_EMAIL }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Friends friends = new Friends(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2));
        // return friends
        return friends;
    }

    // Getting All Friends
    public List<Friends> getAllFriends() {
        List<Friends> friendsList = new ArrayList<Friends>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_FRIENDS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Friends friends = new Friends();
                friends.setId(Integer.parseInt(cursor.getString(0)));
                friends.setName(cursor.getString(1));
                friends.setEmail(cursor.getString(2));
                // Adding contact to list
                friendsList.add(friends);
            } while (cursor.moveToNext());
        }

        // return contact list
        return friendsList;
    }

    // Updating single contact
    public int updateContact(Friends friends) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        //values.put(KEY_ID, friends.getId());
        values.put(KEY_NAME, friends.getName());
        values.put(KEY_EMAIL, friends.getEmail());

        // updating row
        return db.update(TABLE_FRIENDS, values, KEY_ID + " = ?",
                new String[] { String.valueOf(friends.getId()) });
    }

    // Deleting single contact
    public void deleteContact(Friends friends) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_FRIENDS, KEY_ID + " = ?",
                new String[] { String.valueOf(friends.getId()) });
        db.close();
    }


    // Getting contacts Count
    public int getContactsCount() {
        String countQuery = "SELECT  * FROM " + TABLE_FRIENDS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }

}