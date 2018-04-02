package com.example.dj954347.constructionprojectassistant.database.database;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;

import com.example.dj954347.constructionprojectassistant.database.database.CustomerDbSchema.CustomerTable;

/**
 * Created by Dymyll on 4/1/2018.
 */

public class CustomerBaseHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "customerBase.db";

    public CustomerBaseHelper(Context context){
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public  void onCreate(SQLiteDatabase db){

        db.execSQL("create table " + CustomerTable.NAME + "(" +
        " _id integer primary key autoincrement, " +
        CustomerTable.Cols.UUID + ", " +
        CustomerTable.Cols.FIRSTNAME + ", " +
        CustomerTable.Cols.LASTNAME + ", " +
                CustomerTable.Cols.EMAILADDRESS + ", " +
                CustomerTable.Cols.DATEOFBIRTH + ", " +
                CustomerTable.Cols.PASSWORD +
        ")"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

        db.execSQL("DROP IF TABLE EXISTS " + CustomerTable.NAME);
        onCreate(db);
    }
}
