package com.example.xlapplication.viewmodel

import android.app.Application
import android.text.Editable
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.xlapplication.db.UserDataClass
import com.example.xlapplication.repository.UserDataRepository
import kotlinx.coroutines.launch

class UserViewModel(
    val app: Application,
    val repository: UserDataRepository
) : AndroidViewModel(app){

    private var _userDataResponse : MutableLiveData<UserDataClass> = MutableLiveData()
    val userDataResponse : LiveData<UserDataClass> = _userDataResponse

    private var _personalInfo : HashMap<Int, String> = HashMap()
    val personalInfo : HashMap<Int, String> = _personalInfo


    fun personInfoData(fName: String, lName: String, phone: String, gender: String){
        _personalInfo.put(1,fName)
        _personalInfo.put(2,lName)
        _personalInfo.put(3, phone)
        _personalInfo.put(4, gender)
    }

    fun employeeData(eNumber: String, eName:String){
        _personalInfo.put(5,eNumber)
        _personalInfo.put(6,eName)
    }


    fun insertData(id: Int?, first: String, second: String, phone: String,gender: String,
                   employeeNumber: String,
                   employeeName: String,
                   bankName: String,
                   branchName: String,
                   accNumber: String,
                   ifscCode: String){
        viewModelScope.launch {
            repository.upsert(id, first, second, phone,gender,employeeNumber, employeeName,bankName,branchName,accNumber,ifscCode)
        }
    }

    fun getUserData() =
        repository.retrieveData()


    fun deleteData(id: Int? ,first : String,second: String, phone: String,gender: String,
                   employeeNumber: String,
                   employeeName: String,
                   bankName: String,
                   branchName: String,
                   accNumber: String,
                   ifscCode: String){
        viewModelScope.launch {
            repository.deleteData(id, first, second, phone,gender,employeeNumber, employeeName,bankName,branchName,accNumber,ifscCode)
        }
    }
}