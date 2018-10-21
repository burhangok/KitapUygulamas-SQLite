package com.teknodate.smekyayinlari;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class Veritabani extends SQLiteOpenHelper {

    public static final String VT_ADI="ISMEK";
    public  static final String TABLO_ADI="kitaplar";


    public Veritabani(Context context, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, VT_ADI, factory, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        String sqlCumlesi = "CREATE TABLE " + TABLO_ADI + "(id INTEGER PRIMARY KEY AUTOINCREMENT,barkod_no TEXT,kitap_ismi TEXT" + ")";


        db.execSQL(sqlCumlesi);



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public void yeniKitapKaydet(Kitap kitap) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues veriler = new ContentValues();
        veriler.put("barkod_no",kitap.getBarkod_no());
        veriler.put("kitap_ismi",kitap.getKitap_ismi());

        db.insert(TABLO_ADI,null,veriler);
        db.close();

    }


    public List<Kitap> kitaplariGetir(){

        List<Kitap> kitaplar = new ArrayList<Kitap>();

        SQLiteDatabase database =this.getWritableDatabase();


        /*1.Yöntem
        String sqlCumlesi= "SELECT * FROM "+ TABLO_ADI;

        Cursor cursorNesnesi = database.rawQuery(sqlCumlesi,null);

       -- 1.Yöntem */

        Cursor cursor = database.query(TABLO_ADI,new String [] {"id","barkod_no","kitap_ismi"},null,null,null,null,null);


        while (cursor.moveToNext()) {

            Kitap kitap = new Kitap();
            kitap.setBarkod_no(cursor.getString(1));
            kitap.setKitap_ismi(cursor.getString(2));
            kitaplar.add(kitap);
        }

        return kitaplar;

    }




}
