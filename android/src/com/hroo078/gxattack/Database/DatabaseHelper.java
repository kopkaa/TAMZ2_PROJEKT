package com.hroo078.gxattack.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.hroo078.gxattack.AndroidLauncher;

import java.util.ArrayList;
import java.util.List;


public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "score.db";
    private static final Integer DB_VERSION = 1;
    private static DatabaseHelper dbInstance = null;
    public static ArrayList<String> arrayList = new ArrayList<String>();

    private DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public static DatabaseHelper getInstance(Context context){

        if(dbInstance == null) {
            dbInstance = new DatabaseHelper(context.getApplicationContext());
        }
        return dbInstance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_HIGH_SCORE_TABLE = "CREATE TABLE score (_id INTEGER PRIMARY KEY AUTOINCREMENT, score INTEGER,  timestamp DATETIME DEFAULT CURRENT_TIMESTAMP)";
        db.execSQL(CREATE_HIGH_SCORE_TABLE);
    }

    public int getHighScore() {
        int score = 0;
        String GET_HIGH_SCORE = "select score from score order by score desc limit 1";
        Cursor res =  this.getReadableDatabase().rawQuery( GET_HIGH_SCORE, null );
        res.moveToFirst();

        if(res.moveToFirst()) {
            score = res.getInt(0);
        }
        res.close();
        return score;
    }

    public boolean insert(int score) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("score", score);
        long insertedId = db.insert("score", null, contentValues);
        if (insertedId == -1) return false;
        return true;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}