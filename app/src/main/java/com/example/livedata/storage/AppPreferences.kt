package com.example.livedata.storage

import android.content.Context
import com.example.livedata.dagger.qualifier.ApplicationContext
import javax.inject.Inject

class AppPreferences @Inject constructor(@ApplicationContext context: Context) {

    private val sharedPreferences = context.getSharedPreferences("Dagger", Context.MODE_PRIVATE)


    fun setString(key: String, value: String) {
        with(sharedPreferences.edit()) {
            putString(key, value)
            apply()
        }
    }

    fun getString(key: String): String {
        return sharedPreferences.getString(key, "")!!
    }
}