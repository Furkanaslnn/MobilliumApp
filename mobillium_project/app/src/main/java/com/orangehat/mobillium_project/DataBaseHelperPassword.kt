package com.orangehat.mobillium_project

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.EditText
import android.widget.Toast
import android.widget.TextView

val database_name2 = "Veritabanim"
val table_name2 = "Sifreler"
val col_passwordName2 = "sifreadi"
val col_password2 = "sifre"
val col_id2 = "id"

class DataBaseHelperPassword(var context: Context) : SQLiteOpenHelper(context, database_name2, null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {
        // Veritabanı oluştugunda bir kez çalış
        var createTable = " CREATE TABLE " + table_name2 + " (" +
                col_id2 + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                col_passwordName2 + " VARCHAR(256), " +
                col_password2 + " VARCHAR(256) )"
        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
        // Veritabanı yükseltmek içinkullanılır
    }

    // Veri kaydetmek için fonksiyon tanımlıyoruz.
    fun insertData(kullanici: Passwords) {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(col_passwordName2, kullanici.passwordName)
        cv.put(col_password2, kullanici.password)
        var sonuc = db.insert(table_name2, null, cv)
        if (sonuc == (-1).toLong()) {
            Toast.makeText(context, "Hatalı!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Başarılı!", Toast.LENGTH_SHORT).show()
        }
    }

    //verileri okumak için fonksiyon tanımlıyoruz.
    @SuppressLint("Range")
    fun readData(): MutableList<Passwords> {
        var liste: MutableList<Passwords> = ArrayList()
        val db = this.readableDatabase
        var sorgu = "Select * from " + table_name2
        var sonuc = db.rawQuery(sorgu, null)
        if (sonuc.moveToFirst()) {
            do {
                var kullanici = Passwords()
                kullanici.id = sonuc.getString(sonuc.getColumnIndex(col_id2)).toInt()
                kullanici.passwordName = sonuc.getString(sonuc.getColumnIndex(col_passwordName2))
                kullanici.password = sonuc.getString(sonuc.getColumnIndex(col_password2))
                liste.add(kullanici)

            } while (sonuc.moveToNext())
        }
        sonuc.close()
        db.close()
        return liste
    }

    @SuppressLint("Range")
    fun searchInData(searchShowPasswd: String): MutableList<Passwords> {
        val result: MutableList<Passwords> = ArrayList()
        val db = this.readableDatabase
        val sorgu = "SELECT * FROM $table_name2 WHERE $col_passwordName2 LIKE '%$searchShowPasswd%'"
        val sonuc = db.rawQuery(sorgu, null)

        if (sonuc.moveToFirst()) {
            do {
                val kullanici = Passwords()
                kullanici.id = sonuc.getString(sonuc.getColumnIndex(col_id2)).toInt()
                kullanici.passwordName = sonuc.getString(sonuc.getColumnIndex(col_passwordName2))
                kullanici.password = sonuc.getString(sonuc.getColumnIndex(col_password2))
                result.add(kullanici)
            } while (sonuc.moveToNext())
        }

        sonuc.close()
        db.close()
        return result
    }
}