package com.example.damapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class addActivity2 extends AppCompatActivity {
    ListView lv;
    DBhelper mdb;
    Cursor cursor;
    MyCursorAdapter ca;
   // SQLiteDatabase sqldb;
   // String[] id;
  //  String[] first_name;
  //  String[] last_name;
  //  int[] tel;
  //  String[] email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add2);

        mdb = new DBhelper(addActivity2.this);
       // lv = findViewById(R.id.lv);
        cursor = (Cursor) mdb.getEmployee(" ");
         ca = new MyCursorAdapter(this, cursor);
        lv = this.findViewById(R.id.lv);
        lv.setAdapter(ca);

        //CursorAdapter ca= new CursorAdapter (this,cursor )
        //lv.setAdapter(ca);


    }
    // private void did(){
    //   sqldb = mdb.getReadableDatabase();
    //  Cursor cursor=sqldb.rawQuery("select frome" +
    // " * my_employees",null);
    //  if(cursor.getCount()>0) {
    //    id =new String[cursor.getCount()];
    //   first_name=new String[cursor.getCount()];
    //   last_name=new String[cursor.getCount()];
    //  tel =new int[cursor.getCount()];
    //   email=new String[cursor.getCount()];
    //  int i=0;
    // while (cursor.moveToNext()){
    //   id[i]= String.valueOf(cursor.getInt(0));
    // //first_name[i]= String.valueOf(cursor.getInt(1));
    // last_name[i]= String.valueOf(cursor.getInt(2));
    //    tel[i]=cursor.getInt(3);
    //   email[i]= String.valueOf(cursor.getInt(4));
    //  i++;
    // }
    // MyCursorAdapter adapter = new MyCursorAdapter(this,cursor);
    // lv.setAdapter(adapter);

    // }

}