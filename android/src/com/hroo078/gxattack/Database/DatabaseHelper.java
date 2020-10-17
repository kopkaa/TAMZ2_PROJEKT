package com.hroo078.gxattack.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "score.db";
    private static final Integer DB_VERSION = 1;


    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_HIGH_SCORE_TABLE = "CREATE TABLE score (id INTEGER PRIMARY KEY AUTOINCREMENT, player_name TEXT, score INTEGER, time TEXT)";
        db.execSQL(CREATE_HIGH_SCORE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}