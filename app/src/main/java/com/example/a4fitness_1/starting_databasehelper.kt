package com.example.a4fitness_1
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "mydatabase.db"
        private const val DATABASE_VERSION = 1

        // Define the table name and column names
        const val TABLE_NAME = "mytable"
        const val COLUMN_ID = "_id"
        const val COLUMN_NAME = "name"
        const val COLUMN_STARTING_KG = "starting_kg"
        const val COLUMN_GOAL_KG = "goal_kg"
        const val COLUMN_USER = "user"
    }

    override fun onCreate(db: SQLiteDatabase) {
        // Define the SQL statement to create the table
        val CREATE_TABLE_SQL = "CREATE TABLE $TABLE_NAME (" +
                "$COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "$COLUMN_NAME TEXT," +
                "$COLUMN_STARTING_KG REAL," +
                "$COLUMN_GOAL_KG REAL," +
                "$COLUMN_USER TEXT" +
                ")"

        // Execute the SQL statement to create the table
        db.execSQL(CREATE_TABLE_SQL)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Implement database upgrade logic here
    }
}
