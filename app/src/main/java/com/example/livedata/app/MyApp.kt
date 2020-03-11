package com.example.livedata.app

import android.app.Application
import com.example.livedata.dagger.AppComponent
import com.example.livedata.dagger.DaggerAppComponent

class MyApp : Application() {

    lateinit var appComponent:  AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().build()
    }
}