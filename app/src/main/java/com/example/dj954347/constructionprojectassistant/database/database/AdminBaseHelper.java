package com.example.dj954347.constructionprojectassistant.database.database;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;

import com.example.dj954347.constructionprojectassistant.database.database.AdminDbSchema.AdminTable;

/**
 * Created by Dymyll on 4/1/2018.
 * testing
 */

public class AdminBaseHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "adminBase.db";

    public AdminBaseHelper(Context context){
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public  void onCreate(SQLiteDatabase db){

        db.execSQL("create table " + AdminTable.NAME + "(" +
                " _id integer primary key autoincrement, " +
                AdminTable.Cols.UUID + ", " +
                AdminTable.Cols.FIRSTNAME + ", " +
                AdminTable.Cols.LASTNAME + ", " +

                AdminTable.Cols.ADMINNAME + ", " +
                AdminTable.Cols.EMAILADDRESS + ", " +
                AdminTable.Cols.DATEOFBIRTH + ", " +
                AdminTable.Cols.PASSWORD +

                ")"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

//        db.execSQL("DROP IF TABLE EXISTS " + CustomerTable.NAME);
//        onCreate(db);
    }
}
