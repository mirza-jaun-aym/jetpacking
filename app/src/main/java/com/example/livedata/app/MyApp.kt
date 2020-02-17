package com.example.livedata.app

import android.app.Application
import com.example.livedata.dagger.DaggerMagicBox
import com.example.livedata.dagger.MagicBox

class MyApp : Application() {

    lateinit var appComponent:  MagicBox

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerMagicBox.builder().build()
    }
}