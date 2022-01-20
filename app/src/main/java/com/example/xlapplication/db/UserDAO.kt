package com.example.xlapplication.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertData(userData: UserDataClass): Long

    @Query("SELECT * from users1")
    fun getAllData() : LiveData<List<UserDataClass>>

    @Delete
    suspend fun deleteData(userData: UserDataClass)

}