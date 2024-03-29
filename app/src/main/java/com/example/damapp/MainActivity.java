package com.example.damapp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.nio.DoubleBuffer;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    Button add;
    Button consult;
    EditText id,first_name,last_name,tel ,email;
    DBhelper  db;
    Intent intent;


    @Override
    protected void onCreate(  Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);
      //lv=findViewById(R.id.lv);
        id=findViewById(R.id.id);
        first_name=findViewById(R.id.fname);
        last_name=findViewById(R.id.lname);
        tel=findViewById(R.id.tel);
        email=findViewById(R.id.email);

        consult= findViewById(R.id.btConsult);
        consult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 intent = new Intent(MainActivity.this,addActivity2.class);
                startActivity(intent);
            }
        });


        add = findViewById(R.id.btnadd);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
                        public void onClick(View v) {
                db = new DBhelper(MainActivity.this);
                db.addEmployee( id.getText().toString().trim(),first_name.getText().toString(),last_name.getText().toString(),Integer.valueOf(tel.getText().toString().trim()),email.getText().toString().trim() );

            }
        });


    }








}
