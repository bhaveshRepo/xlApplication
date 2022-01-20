package com.example.xlapplication.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(
    tableName = "users1"
)
data class UserDataClass (

    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val firstName: String,
    val lastName: String,
    val phoneNumber: String,
    val gender: String,
    val employeeNumber: String,
    val employeeName: String,
//    val designation: String,
//    val accountType: String,
//    val workExperience: String,
    val bankName: String,
    val bankBranch: String,
    val AccountNo: String,
    val ifscCode: String ) : Serializable