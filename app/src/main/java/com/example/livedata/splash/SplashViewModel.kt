package com.example.livedata.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.livedata.repositories.AppRepository
import javax.inject.Inject

class SplashViewModel(val appRepository: AppRepository) : ViewModel(){

    fun checkUserCredentials() : LiveData<Boolean> {
        val credentialsLiveData: MutableLiveData<Boolean> = MutableLiveData()
        if (appRepository.checkUserCredentials() == ""){
            credentialsLiveData.value = false
        }else{
            credentialsLiveData.value = true
        }
      return  credentialsLiveData
    }

    @Suppress("UNCHECKED_CAST")
    class SplashViewModelFactory @Inject constructor(val appRepository: AppRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return SplashViewModel(appRepository) as T
        }
    }

}