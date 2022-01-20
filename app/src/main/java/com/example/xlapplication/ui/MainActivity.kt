package com.example.xlapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.example.xlapplication.R
import com.example.xlapplication.databinding.ActivityMainBinding
import com.example.xlapplication.db.UserDatabase
import com.example.xlapplication.repository.UserDataRepository
import com.example.xlapplication.viewmodel.UserViewModel
import com.example.xlapplication.viewmodel.UserViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityMainBinding
    private val binding get() = _binding

     lateinit var hostViewModel : UserViewModel
    private lateinit var repository: UserDataRepository


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        repository = UserDataRepository(UserDatabase(this))
        val viewModelProviderFactory = UserViewModelFactory(application,repository)
        hostViewModel = ViewModelProvider(this,viewModelProviderFactory).get(UserViewModel::class.java)

        val hostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment



    }
}