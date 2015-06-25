package com.example.n33r.presentationproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by N33R on 6/5/2015.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    static final String DATABASE_NAME="EMPLYEELIST";
    static final int BD_VERSION=1;
    static final String TABLE_NAME="EMPLYEETABLE";
    static final String KEY_NAME="NAME";
    static final String KEY_PHONE="PHONE";
    static final String KEY_EMAIL="EMAIL";
    static final String KEY_BIRTHDAY="BIRTHDAY";
    static final String KEY_ID="ID";
    static final String KEY_NID="NID";
    static final String KEY_SALARY="SALARY";
    static final String CREATE="create TABLE " +TABLE_NAME+ "(" +KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +KEY_NAME + " TEXT,"
            + KEY_PHONE +" TEXT , "+ KEY_EMAIL + " TEXT, " + KEY_BIRTHDAY + " TEXT , " +KEY_NID + " TEXT," +KEY_SALARY +
            " TEXT);";
    SQLiteDatabase database;


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, BD_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL(CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
     db.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME);
        onCreate(db);
    }
    public void insertemplyee(Emplyee emplyee)
    {
        ContentValues contentValues=new ContentValues();
        contentValues.put(KEY_NAME,emplyee.getName());
        contentValues.put(KEY_PHONE,emplyee.getPhone());
        contentValues.put(KEY_EMAIL,emplyee.getEmail());
        contentValues.put(KEY_BIRTHDAY,emplyee.getBirthday());
        contentValues.put(KEY_NID,emplyee.getNid());
        contentValues.put(KEY_SALARY,emplyee.getSalary());
        database=getWritableDatabase();
        long id =database.insert(TABLE_NAME,null,contentValues);
        Log.e("insertt", id + "");
    }
    public  ArrayList<Emplyee> getAllEmployee()
    {
        ArrayList<Emplyee> list=new ArrayList<>();
        Cursor cursor=getReadableDatabase().query(TABLE_NAME, null, null, null, null, null, null);
        if(cursor.moveToFirst())
        {
            do {
                Emplyee emplyee=new Emplyee(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6));
                list.add(emplyee);
            } while (cursor.moveToNext());
        }
        return list;
    }
    public int delete(String id)
    {

        return getWritableDatabase().delete(TABLE_NAME,KEY_ID+"=?",new String[]{id});
    }
    public int update(String id,ContentValues values)
    {

        return getWritableDatabase().update(TABLE_NAME,values,KEY_ID+"=?",new String[]{id});
    }
}
