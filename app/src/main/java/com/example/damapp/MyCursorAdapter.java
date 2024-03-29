package com.example.damapp;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class MyCursorAdapter extends CursorAdapter {
TextView text_id,text_first_name,text_last_name,text_tel_number,text_email;
String id,first_name,last_name,email;
int tel;
     public MyCursorAdapter (Context context, Cursor cursor) {
         super(context,cursor,0);
     }
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.item,parent,false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        text_id = view.findViewById(R.id.text1);
        text_first_name= view.findViewById(R.id.text2);
        text_last_name = view.findViewById(R.id.text3);
        text_tel_number = view.findViewById(R.id.text4);
        text_email = view.findViewById(R.id.text5);

         id = cursor.getString(0);
        first_name = cursor.getString(1);
        last_name= cursor.getString(2);
         tel = cursor.getInt(3);
         email = cursor.getString(4);

        text_id.setText(id);
        text_first_name.setText(first_name);
        text_last_name.setText(last_name);
        text_tel_number.setText(tel);
        text_email.setText(email);

    }
}
