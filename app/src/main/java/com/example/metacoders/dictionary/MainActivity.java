package com.example.metacoders.dictionary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
public Button add_button ;
public EditText input_data ;
DatabaseHelper mDB ;
String in_data ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add_button= (Button)findViewById(R.id.ADD_btn) ;
        input_data = (EditText)findViewById(R.id.editText_input);
        mDB = new DatabaseHelper(this);

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                in_data = input_data.getText().toString();
                if(input_data.length() != 0 ){
                    AddData(in_data);
                    input_data.setText("");
                }
                else {
                   Toast.makeText(getApplicationContext() , "ENter something ",Toast.LENGTH_LONG).show();

                }

            }
        });






    }

  public  void   AddData(String Data ){
        boolean  insertData = mDB.addData(Data);
        if (insertData){
            Toast.makeText(this ,"Data Saved " , Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this ,"Data NOT  SAVED  " , Toast.LENGTH_SHORT).show();
        }


  }
}
