package com.example.metacoders.dictionary;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private  static  final String Tag = "DatabaseHelper";
    private  static  final String COL0 = "ID" ;
    private  static  final String COL1= "name";
    private  static  final String TABLE_NAME ="users_data";



    public DatabaseHelper(Context context) {

        super(context,TABLE_NAME, null, 1);


    }

    @Override
    public void onCreate(SQLiteDatabase db) {
            String createTable = "CREATE TABLE "+ TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,"+
                    COL1 +" TEXT)";
            db.execSQL(createTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);


    }

    public  boolean addDATA(String name ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues  content = new ContentValues() ;
        content.put(COL1 ,name  );

        long result = db.insert(TABLE_NAME, null, content);

       if(result == -1){

           return  false ;

       }
       else {

           return  true ;
       }




    }
    public  Cursor getdata(){
        SQLiteDatabase db = this.getWritableDatabase() ;
        String query = "SELECT * FROM " + TABLE_NAME ;
        Cursor data =db.rawQuery(query , null);
        return  data ;


    }






}
