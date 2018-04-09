package com.example.dj954347.constructionprojectassistant.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/**
 * Created by troyr on 4/1/2018.
 */

import com.example.dj954347.constructionprojectassistant.database.ProjectsDbSchema.ProjectTable;

public class ProjectBaseHelper extends SQLiteOpenHelper {
    private static final int VERSION =1;
    private static final String DATABASE_NAME = "projectBase.db";

    public ProjectBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + ProjectTable.NAME + "(" +
                " _id integer primary key autoincrement, " +
                ProjectTable.Cols.UUID + ", " +
                ProjectTable.Cols.NAME + ", " +
                ProjectTable.Cols.Address + ", " +
                ProjectTable.Cols.Description + ","+
                ProjectTable.Cols.CompletionDate +
                ")"

        );
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }
}
