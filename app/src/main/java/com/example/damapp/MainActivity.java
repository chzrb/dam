package com.example.damapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    Button add;
    Button consult;
    Button consult2;
    EditText id,first_name,last_name,tel ,email;
    DBhelper  db;

    @Override
    protected void onCreate(  Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);

        id=findViewById(R.id.id);
        first_name=findViewById(R.id.fname);
        last_name=findViewById(R.id.lname);
        tel=findViewById(R.id.tel);
        email=findViewById(R.id.email);

        //CONSULT EMPLOYREE GRID
        consult= findViewById(R.id.btConsult);
        consult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( MainActivity.this, addActivityGRID2.class );
                startActivity(intent);
            }
        });

        // CONSULT EMPLOYEE LIST
        consult2= findViewById(R.id.btnConsult2);

        consult2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( MainActivity.this, addActivity2.class );
                startActivity(intent);
            }
        });

        // ADD EMPLOYEE
        add = findViewById(R.id.btnadd);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db = new DBhelper(MainActivity.this);
                Employee e = new Employee(id.getText().toString(), first_name.getText().toString(), last_name.getText().toString(), Integer.valueOf(tel.getText().toString().trim()), email.getText().toString());
                  db.addEmployee(e);

                id.setText("");
               first_name.setText("");
                last_name.setText("");
                tel.setText("");
                email.setText("");
            }
        });

    }
}
