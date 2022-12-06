package com.adrianmarino.e_salansan

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast


val DATABASE_NAME = "ESalansanDB"
val TABLE_NAME = "tblAccounts"
val COL_ID = "_id"
val COL_USERNAME = "username"
val COL_PASSWORD = "password"
val COL_CHALLENGE_ONE_HIGH_SCORE = "chOneHighScore"
val COL_CHALLENGE_TWO_HIGH_SCORE = "chTwoHighScore"
val COL_CHALLENGE_THREE_HIGH_SCORE = "chThreeHighScore"
val COL_CHALLENGE_FOUR_HIGH_SCORE = "chFourHighScore"
val COL_CHALLENGE_FIVE_HIGH_SCORE = "chFiveHighScore"
val COL_CHALLENGE_SIX_HIGH_SCORE = "chSixHighScore"

class DatabaseHandler(var context : Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, 1) {


    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CREATE TABLE $TABLE_NAME ($COL_ID INTEGER PRIMARY KEY AUTOINCREMENT, $COL_USERNAME VARCHAR(15), $COL_PASSWORD VARCHAR(15), " +
                "$COL_CHALLENGE_ONE_HIGH_SCORE INTEGER, $COL_CHALLENGE_TWO_HIGH_SCORE INTEGER, $COL_CHALLENGE_THREE_HIGH_SCORE INTEGER, $COL_CHALLENGE_FOUR_HIGH_SCORE," +
                "$COL_CHALLENGE_FIVE_HIGH_SCORE INTEGER, $COL_CHALLENGE_SIX_HIGH_SCORE INTEGER)"
        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    fun insertData(user: User){
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(COL_USERNAME,user.username)
        cv.put(COL_PASSWORD,user.password)
        cv.put(COL_CHALLENGE_ONE_HIGH_SCORE, 0)
        cv.put(COL_CHALLENGE_TWO_HIGH_SCORE, 0)
        cv.put(COL_CHALLENGE_THREE_HIGH_SCORE, 0)
        cv.put(COL_CHALLENGE_FOUR_HIGH_SCORE, 0)
        cv.put(COL_CHALLENGE_FIVE_HIGH_SCORE, 0)
        cv.put(COL_CHALLENGE_SIX_HIGH_SCORE, 0)

        var result = db.insert(TABLE_NAME, null, cv)
        if (result == (-1).toLong()) {
            Toast.makeText(context, "Failed!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Successfully Registered!", Toast.LENGTH_SHORT).show()
        }
    }

    fun readData() : MutableList<User>{
        var list : MutableList<User> = ArrayList()
        val db = this.readableDatabase
        val query = "SELECT * FROM $TABLE_NAME"
        val result = db.rawQuery(query,null)
        if (result.moveToFirst()){
            do{
                var user = User()
                user.id = result.getString(result.getColumnIndex(COL_ID)).toInt()
                user.username = result.getString(result.getColumnIndex(COL_USERNAME)).toString()
                user.password = result.getString(result.getColumnIndex(COL_PASSWORD)).toString()
                user.challenge1_high_score = result.getString(result.getColumnIndex(
                    COL_CHALLENGE_ONE_HIGH_SCORE)).toInt()
                user.challenge2_high_score = result.getString(result.getColumnIndex(
                    COL_CHALLENGE_TWO_HIGH_SCORE)).toInt()
                user.challenge3_high_score = result.getString(result.getColumnIndex(
                    COL_CHALLENGE_THREE_HIGH_SCORE)).toInt()
                user.challenge4_high_score = result.getString(result.getColumnIndex(
                    COL_CHALLENGE_FOUR_HIGH_SCORE)).toInt()
                user.challenge5_high_score = result.getString(result.getColumnIndex(
                    COL_CHALLENGE_FIVE_HIGH_SCORE)).toInt()
                user.challenge6_high_score = result.getString(result.getColumnIndex(
                    COL_CHALLENGE_SIX_HIGH_SCORE)).toInt()
                list.add(user)
            }while(result.moveToNext())
        }
        result.close()
        db.close()
        return list
    }

    fun updateChallenge1HighScoreData(high_score : Int, _id : Int){
        val db = this.writableDatabase
        val query = "SELECT * FROM $TABLE_NAME"
        val result = db.rawQuery(query,null)
        if (result.moveToFirst()){
            do{
                var cv = ContentValues()
                cv.put(COL_CHALLENGE_ONE_HIGH_SCORE, high_score)
                db.update(TABLE_NAME, cv, "$COL_ID = $_id", null)
            }while(result.moveToNext())
        }
        result.close()
        db.close()
    }


}