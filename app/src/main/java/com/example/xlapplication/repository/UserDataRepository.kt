package com.example.xlapplication.repository

import com.example.xlapplication.db.UserDataClass
import com.example.xlapplication.db.UserDatabase

class UserDataRepository( val userDb: UserDatabase) {


    suspend fun upsert(id: Int? ,
                       first : String,
                       second: String,
                       phone: String,
                       gender: String,
                       employeeNumber: String,
                       employeeName: String,
                       bankName: String,
                       branchName: String,
                       accNumber: String,
                       ifscCode: String
                        ) = userDb.userDao().insertData(UserDataClass(
            null,first,second,phone,gender,employeeNumber,employeeName,bankName,branchName,accNumber,ifscCode))

    fun retrieveData() = userDb.userDao().getAllData()

    suspend fun deleteData(id: Int? ,
                           first : String,
                           second: String,
                           phone: String,
                           gender: String,
                           employeeNumber: String,
                           employeeName: String,
                           bankName: String,
                           branchName: String,
                           accNumber: String,
                           ifscCode: String) = userDb.userDao().deleteData(UserDataClass(
        null,first,second,phone,gender,employeeNumber,employeeName,bankName,branchName,accNumber,ifscCode))


}