package com.example.damapp;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
public class addActivity3 extends AppCompatActivity  {
ImageView imageView;
TextView t1, t2, t3, t4, t5;
Button Delete, Update,Contact;
FloatingActionButton fbtn;
   // private Instant ImagePicker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add3);

        String id = getIntent().getExtras().getString("id");
        String fn = getIntent().getExtras().getString("fn");
        String ln = getIntent().getExtras().getString("ln");
        int te = getIntent().getExtras().getInt("te");
        String eml = getIntent().getExtras().getString("eml");

        t1 = findViewById(R.id.text11);
        t2 = findViewById(R.id.text22);
        t3 = findViewById(R.id.text33);
        t4 = findViewById(R.id.text44);
        t5 = findViewById(R.id.text55);


        t1.setText(id);
        t2.setText(fn);
        t3.setText(ln);
        t4.setText(String.valueOf(te));
        t5.setText(eml);

        // UPDATE
        Update = findViewById(R.id.btnUpdate);
        Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DBhelper d = new DBhelper(addActivity3.this);

                String i = t1.getText().toString().trim();
                String f = t2.getText().toString().trim();
                String l = t3.getText().toString().trim();
                int t = Integer.valueOf(t4.getText().toString().trim());
                String e = t5.getText().toString().trim();

                d.update(i, f, l, t, e);
            }
        });

        // DELETE
        Delete = findViewById(R.id.btnDelete);
        Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBhelper dd = new DBhelper(addActivity3.this);
                String i = t1.getText().toString().trim();
                dd.delete(i);
            }
        });

        //CONTACT
        Contact=findViewById(R.id.btnContact);
        Contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent( addActivity3.this, addActivity4.class );
                startActivity(intent);
            }
        });


        fbtn = findViewById(R.id.floatingActionButton);
        //MaterialButton pickImage = findViewById(R.id.pickImage);





        //fbtn = findViewById(R.id.floatingActionButton);
        //fbtn.setOnClickListener(new View.OnClickListener() {
          //  @Override
            //public void onClick(View v) {
               // if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                  //  ImagePicker.with((TemporalAdjuster) addActivity3.this).clone().compress(1024).maxResultsize(1080, 1080).start();
                //  boolean a = true;
               // if (a == true)
                  //  if (!checkCameraPermission()){
                      //  requestCameraPermissions();

                        // }else
                       // PickImage(); }
              //  else{
                     //  if (!checkStoragePermission()) {
                          //  requestStoragePermissions();
                       // } else {
                           //PickImage();
                      //  }
                   //}





           // }

        //});



    }











   // private void PickImage() {

       // CropImage.activity().start(this);



   // }

   // private void requestStoragePermissions() {
       // requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},100);
   // }

   // private boolean checkStoragePermission() {
     //   boolean bb = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED;
      //  return bb;
   // }

  //  private void requestCameraPermissions() {
    //    requestPermissions(new String[]{Manifest.permission.CAMERA,Manifest.permission.WRITE_EXTERNAL_STORAGE},100);

   // }

   // private boolean checkCameraPermission() {
      //  boolean b = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED;
       // boolean bb = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED;
       // return  b&&bb;

  //  }


    //private class Builder {


     //   private ActivityResultContracts.PickVisualMedia.ImageOnly mediaType;

      //  public void setMediaType(ActivityResultContracts.PickVisualMedia.ImageOnly mediaType) {
         //   this.mediaType = mediaType;
       // }

      //  public ActivityResultContracts.PickVisualMedia.ImageOnly getMediaType() {
          //  return mediaType;
      //  }
  //  }
}
