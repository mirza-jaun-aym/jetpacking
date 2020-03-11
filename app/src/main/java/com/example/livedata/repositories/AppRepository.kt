package com.example.livedata.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.livedata.dagger.ApplicationScoped
import com.example.livedata.model.Post
import com.example.livedata.network.AppClient
import com.example.livedata.storage.AppPreferences
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

private const val REGISTERED_USER = "registered_user"
private const val PASSWORD_SUFFIX = "password"

@ApplicationScoped
class AppRepository @Inject constructor(val appPreferences: AppPreferences) {


     fun getTodos() : LiveData<List<Post>> {
        val postLiveData: MutableLiveData<List<Post>> = MutableLiveData()

        AppClient.create().hitCountCheck().enqueue(object : Callback<List<Post>> {
            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Log.d("response", "failure")
                t.printStackTrace()
                postLiveData.postValue(null)
            }

            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                postLiveData.postValue(response.body())
            }
        })
        return postLiveData;
    }


    fun registerUser(username: String, password: String) {
        appPreferences.setString(REGISTERED_USER, username)
        appPreferences.setString("$username$PASSWORD_SUFFIX", password)
    }

    fun checkUserCredentials() = appPreferences.getString(REGISTERED_USER)
    fun clearUserCredentials() {
        appPreferences.setString(REGISTERED_USER,"")
    }

}