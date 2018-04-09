package com.example.dj954347.constructionprojectassistant.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/**
 * Created by troyr on 4/1/2018.
 */

import com.example.dj954347.constructionprojectassistant.database.WorkerDbSchema.WorkerTable;

public class WorkerBaseHelper extends SQLiteOpenHelper {
    private static final int VERSION =1;
    private static final String DATABASE_NAME = "workerBase.db";

    public WorkerBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + WorkerTable.NAME + "(" +
                " _id integer primary key autoincrement, " +
                WorkerTable.Cols.UUID + "," +
                WorkerTable.Cols.FirstName + "," +
                WorkerTable.Cols.LastName + "," +
                WorkerTable.Cols.Username + ","+
                WorkerTable.Cols.Password +
                ")"

        );
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }
}