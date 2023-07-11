package com.example.uas.data_base;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class    dataBaseHelper extends SQLiteOpenHelper{

        public static final String API_DB = "api.db";

        public dataBaseHelper(Context context) {
            super(context, API_DB, null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String createQuery = "CREATE TABLE api(id INTEGER PRIMARY KEY, userId INTEGER, title VARCHAR(64), body VARCHAR(256))";
            db.execSQL(createQuery);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            String dropQuery = "DROP TABLE IF EXISTS api";
            db.execSQL(dropQuery);
        }

        public void createAPI(Integer id, Integer userId, String title, String body) {
            SQLiteDatabase db = this.getWritableDatabase();

            if (!checkAPI(id)) {
                ContentValues contentValues = inputAPI(id, userId, title, body);

                long result = db.insert("api", null, contentValues);
                db.close();
            }
        }

        public boolean checkAPI(Integer id) {
            SQLiteDatabase db = this.getWritableDatabase();
            String selectQuery = "SELECT * FROM api WHERE id = ?";
            Cursor cursor = db.rawQuery(selectQuery, new String[]{String.valueOf(id)});

            boolean result = cursor.getCount() > 0;
            cursor.close();
            return result;
        }

        private ContentValues inputAPI(Integer id, Integer userId, String title, String body) {
            ContentValues contentValues = new ContentValues();

            contentValues.put("id", id);
            contentValues.put("userId", userId);
            contentValues.put("title", title);
            contentValues.put("body", body);

            return contentValues;
        }

}
