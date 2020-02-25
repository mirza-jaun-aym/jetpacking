package com.example.livedata.app

import android.app.Application
import com.example.livedata.dagger.ApplicationModule
import com.example.livedata.dagger.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject


open class MyApp : DaggerApplication(), HasAndroidInjector {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
       return DaggerAppComponent.builder().applicationModule(ApplicationModule(this))
            .build()
    }
}