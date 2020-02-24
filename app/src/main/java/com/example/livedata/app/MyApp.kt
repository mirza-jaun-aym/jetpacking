package com.example.livedata.app

import android.app.Application
import com.example.livedata.dagger.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject


open class MyApp : Application(), HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.create()
            .inject(this);
    }

    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector
}