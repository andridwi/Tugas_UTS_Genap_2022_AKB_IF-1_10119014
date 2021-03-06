package com.example.a10119014_andridwip;
// Nama : Andri Dwi P
//NIM : 10119014
//kelas: IF-1

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    private Context ctx;
    private static final String  DATABASE_NAME ="db_catatan";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "tbl_catatan";
    private static final String FIELD_ID = "id";
    private static final String FIELD_JUDUL = "judul";
    private static final String FIELD_PENULIS = "kategori";
    private static final String FIELD_ISI = "isi";
    private static final String FIELD_TAHUN = "tahun";

    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.ctx = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " (" +
                FIELD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                FIELD_JUDUL + " TEXT, " +
                FIELD_PENULIS + " TEXT, "+
                FIELD_ISI + " TEXT, " +
                FIELD_TAHUN + " INTEGER ); " ;

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public long tambahBuku(String judul, String isi, String kategori, int tahun) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(FIELD_JUDUL, judul);
        cv.put(FIELD_PENULIS, kategori);
        cv.put(FIELD_ISI, isi);
        cv.put(FIELD_TAHUN, tahun);

        long eksekusi = db.insert(TABLE_NAME, null, cv);

        return eksekusi;

    }

    public Cursor bacaSemuaData(){
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }

        return cursor;
    }
}
