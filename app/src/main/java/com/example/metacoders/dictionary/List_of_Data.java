package com.example.metacoders.dictionary;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class List_of_Data extends AppCompatActivity {
DatabaseHelper mDatabasehelper ;
private ListView  mlistview ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of__data);

        mlistview = (ListView)findViewById(R.id.listView_data);

        mDatabasehelper = new DatabaseHelper(this);

        populateListView();



    }


  public  void populateListView(){

        //get the data and append in a list
      Cursor data = mDatabasehelper.getdata() ;
      ArrayList <String> listdata = new ArrayList<>() ;
      while(data.moveToNext()){
          //get the valure from the db
          //then add it to the arraylist
          listdata.add(data.getString(1));

      }

      //create the list adapter and set the adapter
      ListAdapter adapter  = new ArrayAdapter<>(this , android.R.layout.simple_list_item_1 , listdata);
      mlistview.setAdapter(adapter);



  }





}
