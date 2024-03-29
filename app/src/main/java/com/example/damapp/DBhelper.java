package com.example.damapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;
public class DBhelper extends SQLiteOpenHelper {
    private final Context context;
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "bd";
    private static final String TABLE_NAME = "my_employees";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_First_NAME = "first_name";
    private static final String COLUMN_Last_NAME = "last_name";
    private static final String COLUMN_TEL = "telephone_number";
    private static final String COLUMN_EMAIL = "email_address";

    public DBhelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase bd) {


        String query = "CREATE TABLE my_employees (id TEXT PRIMARY KEY , " +
                "first_name TEXT," +
                " last_name TEXT," +
                " telephone_number INTEGER," +
                " email_address TEXT);"
                ;

       // String query = "CREATE TABLE my_employees (id TEXT PRIMARY KEY AUTOINCREMENT, first_name TEXT, last_name TEXT, telephone_number INTEGER, email_address TEXT)";

        // " (" +COLUMN_ID + " TEXT  PRIMARY KEY AUTOINCREMENT, " +
               // COLUMN_First_NAME + " TEXT, " +
              //  COLUMN_Last_NAME + " TEXT, " +
              //  COLUMN_TEL + "INTEGER, " +
              //  COLUMN_EMAIL + " TEXT);";
        bd.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int ii) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    //String id;
    public Employee getEmployee (String id) {

       SQLiteDatabase db = this.getReadableDatabase();
       // Cursor cursor = db.rawQuery(" SELECT* FROM TABLE_NAME WHERE" )";
        Cursor cursor = db.rawQuery("SELECT* FROM TABLE_NAME WHERE id=?", new String[]{id});
        if (cursor.getCount() == 0) return null;
        cursor.moveToFirst();
        Employee e = new Employee(cursor.getString(0), cursor.getString(1), cursor.getString(2),
                cursor.getInt(3), cursor.getString(4));
        return e;
    }

    void addEmployee(String id ,String first_name, String last_name, int  tel, String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_ID,id);
        cv.put(COLUMN_First_NAME, first_name);
        cv.put(COLUMN_Last_NAME, last_name);
        cv.put(COLUMN_TEL, tel);
        cv.put(COLUMN_EMAIL, email);

        long result = db.insert(TABLE_NAME, null, cv);

        if (result == -1) {
            Toast.makeText(context, "failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "added Successfully ", Toast.LENGTH_SHORT).show();
        }
        db.close();
    }
}





