package com.pixelart.zooapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String TAG = "DBTag";

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "AnimalseDB";

    private static final String TABLE_NAME = "Animals";
    private static final String ANIMAL_NAME = "Name";
    private static final String ANIMAL_DESCRIPTION = "Description";
    private static final String ANIMAL_LOCATION = "Location";
    private static final String ANIMAL_HABITAT = "Habitat";
    private static final String ANIMAL_DIET = "Diet";
    private static final String ANIMAL_SIZE = "Size";
    private static final String ANIMAL_WEIGHT = "Weight";
    private static final String ANIMAL_STATUS = "Status";
    private static final String ANIMAL_THREATS = "Threats";
    private static final String ANIMAL_CATEGORY = "Category";
    //private static final String ANIMAL_ID = "Id";

    public DatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + ANIMAL_NAME + " TEXT PRIMARY KEY," + ANIMAL_DESCRIPTION +
                " TEXT," + ANIMAL_LOCATION + " TEXT,"  + ANIMAL_HABITAT + " TEXT," +
                ANIMAL_DIET + " TEXT," + ANIMAL_SIZE + " TEXT," + ANIMAL_WEIGHT + " TEXT," + ANIMAL_STATUS + " TEXT," + ANIMAL_THREATS + " TEXT," +
                ANIMAL_CATEGORY + " TEXT" /*+ ANIMAL_ID +" INTEGER PRIMARY KEY AUTOINCREMENT" */ + ")";

        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addAnimals(Animals animals)
    {
        SQLiteDatabase database = this.getReadableDatabase();
        ContentValues values = new ContentValues();

        values.put(ANIMAL_NAME, animals.getName());
        values.put(ANIMAL_DESCRIPTION, animals.getDescription());
        values.put(ANIMAL_LOCATION, animals.getLocation());
        values.put(ANIMAL_HABITAT, animals.getHabitat());
        values.put(ANIMAL_DIET, animals.getDiet());
        values.put(ANIMAL_SIZE, animals.getSize());
        values.put(ANIMAL_WEIGHT, animals.getWeight());
        values.put(ANIMAL_STATUS, animals.getStatus());
        values.put(ANIMAL_THREATS, animals.getThreats());
        values.put(ANIMAL_CATEGORY, animals.getCategory());

        database.insert(TABLE_NAME, null, values);

        Log.d(TAG, "addAnimals");
    }

    public List<Animals> getAllAnimals()
    {
        SQLiteDatabase database = this.getWritableDatabase();
        String query = "Select * from " + TABLE_NAME;

        Cursor cursor = database.rawQuery(query, null);
        List<Animals> animals = new ArrayList<>();
        if (cursor.moveToFirst())
        {
            do
            {
                Animals animal = new Animals(cursor.getString(0), cursor.getString(1),
                        cursor.getString(2), cursor.getString(3),
                        cursor.getString(4), cursor.getString(5), cursor.getString(6),
                        cursor.getString(7), cursor.getString(8));
                animals.add(animal);
            }while (cursor.moveToNext());
        }

        return  animals;
    }
}
