package com.example.lab15


import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDBHelper(
    context: Context,
    name: String = DATABASE_NAME,
    factory: SQLiteDatabase.CursorFactory? = null,
    version: Int = DATABASE_VERSION
) : SQLiteOpenHelper(context, name, factory, version) {

    companion object {
        private const val DATABASE_NAME = "myDatabase" // 資料庫名稱
        private const val DATABASE_VERSION = 1 // 資料庫版本
    }

    override fun onCreate(db: SQLiteDatabase) {
        // 建立 myTable 資料表，該表包含 book 字串欄位和 price 整數欄位
        db.execSQL("CREATE TABLE myTable(book TEXT PRIMARY KEY, price INTEGER NOT NULL)")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // 當資料庫版本升級時，先刪除舊資料表，然後重新建立新的資料表
        db.execSQL("DROP TABLE IF EXISTS myTable")
        onCreate(db)
    }
}
