package com.example.livedata.list

import android.util.Log
import androidx.lifecycle.*
import com.example.livedata.model.Post
import com.example.livedata.network.AppClient
import com.example.livedata.repositories.AppRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class ListViewModel(val appRepository: AppRepository) : ViewModel() {

    fun beginSearchViewModel(): LiveData<List<Post>> {
        val listLiveData: MutableLiveData<List<Post>> = MutableLiveData()

        Transformations.map(appRepository.getTodos(), {
            listLiveData.postValue(it.toList())
        })

        AppClient.create().hitCountCheck().enqueue(object : Callback<List<Post>> {
            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Log.d("response", "failure")
                t.printStackTrace()
                listLiveData.postValue(null)
            }

            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                listLiveData.postValue(response.body())
            }
        })
        return listLiveData
    }

    fun clearPref(): LiveData<Boolean> {
        val prefLiveData = MutableLiveData<Boolean>()
        appRepository.clearUserCredentials()
        prefLiveData.value = false
        return prefLiveData
    }

    @Suppress("UNCHECKED_CAST")
    class ListViewModelFactory @Inject constructor(val appRepository: AppRepository) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return ListViewModel(appRepository) as T
        }
    }
}