package com.example.xlapplication.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.xlapplication.UserApplicationClass
import com.example.xlapplication.db.UserDatabase
import com.example.xlapplication.repository.UserDataRepository

class UserViewModelFactory(

    private val app: Application,
    private val repository: UserDataRepository,

    )  : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return UserViewModel(app ,repository) as T
    }
}