package com.hysaeedi.afinal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

public class MatchResultAdapter {

    Context context;
    SQLiteDatabase db;

    public MatchResultAdapter(Context context) {
        this.context = context;
        MatchDbHelper helper = new MatchDbHelper(context);
        db = helper.getWritableDatabase();
    }

    public boolean insert(MatchResult object) {
        try {
            ContentValues values = new ContentValues();
            values.put("team1title", object.team1title);
            values.put("team2title", object.team2title);
            values.put("team1goals", object.team1goals);
            values.put("team2goals", object.team2goals);
            db.insert("matchresult", null, values);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(MatchResult object) {
        try {
            ContentValues values = new ContentValues();
            values.put("team1title", object.team1title);
            values.put("team2title", object.team2title);
            values.put("team1goals", object.team1goals);
            values.put("team2goals", object.team2goals);
            db.update("matchresult", values, "id = ?", new String[]{String.valueOf(object.id)});
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(int id) {
        try {
            db.delete("matchresult", "id = ?", new String[]{String.valueOf(id)});
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public MatchResult getByid(int id) {
        try {
//            Cursor cursor = db.query("matchresult", new String[]{"id", "team1title", "team2title",
//                    "team1goals", "team2goals"});
            Cursor cursor = db.rawQuery
                    ("SELECT * FROM matchresult WHERE id = ?", new String[]{String.valueOf(id)});
            if (cursor.moveToFirst()) {
                MatchResult matchResult = new MatchResult();
                matchResult.id = cursor.getInt(0);
                matchResult.team1title = cursor.getString(1);
                matchResult.team2title = cursor.getString(2);
                matchResult.team1goals = cursor.getInt(3);
                matchResult.team2goals = cursor.getInt(4);
                return matchResult;
            } else
                return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<MatchResult> getAll() {
        try {
            Cursor cursor = db.rawQuery("SELECT * FROM matchresult", null);
            if (cursor.moveToFirst()) {
                ArrayList<MatchResult> results = new ArrayList<>();
                do {
                    MatchResult matchResult = new MatchResult();
                    matchResult.id = cursor.getInt(0);
                    matchResult.team1title = cursor.getString(1);
                    matchResult.team2title = cursor.getString(2);
                    matchResult.team1goals = cursor.getInt(3);
                    matchResult.team2goals = cursor.getInt(4);
                    results.add(matchResult);
                } while (cursor.moveToNext());
                return results;
            } else
                return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<MatchResult> search(String txt) {
        try {
//            Cursor cursor = db.query("matchresult", new String[]{"id", "team1title", "team2title",
//                    "team1goals", "team2goals"});
            Cursor cursor = db.rawQuery("SELECT * FROM matchresult WHERE team1title LIKE " +
                    "'%" + txt + "%' OR team2title LIKE '?'", null);
            if (cursor.moveToFirst()) {
                ArrayList<MatchResult> results = new ArrayList<>();
                do {
                    MatchResult matchResult = new MatchResult();
                    matchResult.id = cursor.getInt(0);
                    matchResult.team1title = cursor.getString(1);
                    matchResult.team2title = cursor.getString(2);
                    matchResult.team1goals = cursor.getInt(3);
                    matchResult.team2goals = cursor.getInt(4);
                    results.add(matchResult);
                } while (cursor.moveToNext());
                return results;
            } else
                return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
