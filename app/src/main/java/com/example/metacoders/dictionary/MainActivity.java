package com.example.metacoders.dictionary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
public  Button add_btn , Show_btn;
public  EditText input_field ;
String User_name ;
DatabaseHelper mDB ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add_btn= (Button)findViewById(R.id.ADD_btn);
        input_field = (EditText)findViewById(R.id.editText_input) ;
        Show_btn = (Button)findViewById(R.id.button_Show);

        mDB = new DatabaseHelper(this );

        Show_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  i = new Intent(getApplicationContext() , List_of_Data.class);
                startActivity(i);
            }
        });





            add_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    User_name = input_field.getText().toString() ;
                    if(User_name.length() != 0 ){
                        sendDataToDatabase(User_name);
                        input_field.setText("");
                    }
                    else {

                        Toast.makeText(getApplicationContext() , "PLZZ ENTER THE NAME", Toast.LENGTH_SHORT).show();

                    }


                }
            });




    }

    public  void sendDataToDatabase(String name ){
               boolean inserted_data = mDB.addDATA(name);

               if(inserted_data){

                   Toast.makeText(this ,"YOUR NAME HAS BEEN SAVED " , Toast.LENGTH_SHORT ).show();

               }
               else{

                   Toast.makeText(this, " ERROR : YOUR NAME HAS NOT BEEN SAVED " , Toast.LENGTH_LONG).show();
               }




    }






}