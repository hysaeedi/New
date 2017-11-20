package com.hysaeedi.afinal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MatchDbHelper extends SQLiteOpenHelper {
    String matchtablescript = "CREATE TABLE matchresult " +
            "(id integer primary key, team1title text, team2title text," +
            "team1goals integer, team2goals integer)";

    public MatchDbHelper(Context context) {
        super(context, "matches.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(matchtablescript);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
