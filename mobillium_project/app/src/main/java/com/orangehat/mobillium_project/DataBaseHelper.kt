package com.orangehat.mobillium_project

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

val database_name = "MyDataBase"

val table_name = "Users"
val col_id = "id"
val col_username = "username"
val col_password = "password"

class DataBaseHelper (var context: Context): SQLiteOpenHelper(context, database_name, null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        // Veritabanı oluştuğunda bir kez çalışır.
        var createTable = "CREATE TABLE " + table_name + "(" +
                col_id + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                col_username + " VARCHAR(256)," +
                col_password + " VARCHAR(256))"
        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        // Veritabanı yükseltmek.
    }

    // Veri kaydetmek için fonksiyon yazacağız.
    fun insertData(user: User){
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(col_username, user.username)
        cv.put(col_password, user.password)
        var sonuc = db.insert(table_name,null,cv)
        if (sonuc == (-1).toLong()){
            Toast.makeText(context,"Hatalı.",Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(context,"Başarılı.",Toast.LENGTH_SHORT).show()
        }
    }

    // Veriyi okumak içinu
    @SuppressLint("Range")
    fun readData(): MutableList<User> {
        var liste:MutableList<User> = ArrayList()
        val db = this.readableDatabase
        var sorgu = "SELECT * FROM " + table_name
        var sonuc = db.rawQuery(sorgu,null)
        if (sonuc.moveToFirst()){
            do{
                var user = User()
                user.id = sonuc.getString(sonuc.getColumnIndex(col_id)).toInt()
                user.username = sonuc.getString(sonuc.getColumnIndex(col_username))
                user.password = sonuc.getString(sonuc.getColumnIndex(col_password))
                liste.add(user)
            }while (sonuc.moveToNext())
        }
        sonuc.close()
        db.close()
        return liste
    }

}

