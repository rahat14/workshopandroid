package com.example.metacoders.dictionary;

import android.content.ContentValues;
import android.content.Context;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static  final  String Tag = "DatabaseHelper" ;
    private static  final  String COL0 = "ID";
    private  static  final  String COL1 = "Name";
    private static  final  String TABLE_NAME = "users_data";

    public DatabaseHelper(Context context) {
        super(context,TABLE_NAME , null , 1 );
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL1 +" TEXT)";
        sqLiteDatabase.execSQL(createTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

onCreate(sqLiteDatabase);



    }
    public  boolean addData(String item){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues( );
        contentValues.put(COL1 , item);
        Log.d(Tag,"ADD DATA  ADDING :"+ item + "TO"+ TABLE_NAME);
        long result = db.insert(TABLE_NAME , null , contentValues);
        // check did it save it or not .

        if(result == -1  ){
             return  false ;

        }
        else {
            return  true ;
        }
    }

}
