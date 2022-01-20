package com.example.xlapplication.db

import android.content.Context
import android.service.autofill.UserData
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [UserDataClass::class],
    version = 1
)
abstract class UserDatabase : RoomDatabase() {

abstract fun userDao() : UserDAO

companion object{

    private var Instance: UserDatabase? = null

    operator fun invoke(context: Context) = Instance ?: synchronized(this){

        Instance ?: createDatabase(context).also {
           instance ->  Instance = instance
        }

    }

    private fun createDatabase(context: Context) =
        Room.databaseBuilder(context.applicationContext,
            UserDatabase::class.java, "user4_db.db")
            .build()



}

}