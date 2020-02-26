package com.example.livedata.app

import com.example.livedata.dagger.ApplicationModule
import com.example.livedata.dagger.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.HasAndroidInjector


open class MyApp : DaggerApplication(), HasAndroidInjector {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
       return DaggerAppComponent.builder().applicationModule(ApplicationModule(this))
            .build()
    }
}