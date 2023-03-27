package com.example.a4fitness_1
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class starting_databasehelper(startPage: start_page) {

    class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

        companion object {
            private const val DATABASE_VERSION = 1
            private const val DATABASE_NAME = "starting-info.db"
            private const val TABLE_NAME = "info"
            private const val COLUMN_NAME = "name"
            private const val COLUMN_STARTING_KG = "starting_kg"
            private const val COLUMN_GOAL_KG = "goal_kg"
        }

        override fun onCreate(db: SQLiteDatabase) {
            val CREATE_TABLE = "CREATE TABLE $TABLE_NAME ($COLUMN_NAME TEXT, $COLUMN_STARTING_KG REAL, $COLUMN_GOAL_KG REAL)"
            db.execSQL(CREATE_TABLE)
        }

        override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
            db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
            onCreate(db)
        }
    }

}