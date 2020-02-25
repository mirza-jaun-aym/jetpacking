package com.example.livedata.auth

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.livedata.repositories.AppRepository
import javax.inject.Inject

class LoginViewModel(val appRepository: AppRepository) : ViewModel() {


    fun validateInputs(email: String, password: String) {
        appRepository.registerUser(email,password)
        Log.d("LoginViewModel","User Registerd")
    }


    @Suppress("UNCHECKED_CAST")
    class LoginViewModelFactory @Inject constructor(val appRepository: AppRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return LoginViewModel(appRepository) as T
        }

    }
}
