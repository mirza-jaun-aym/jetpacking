package com.example.livedata.app

import android.app.Application
import com.example.livedata.dagger.ApplicationModule
import com.example.livedata.dagger.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject


open class MyApp  : Application(),  HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    /*override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
       return DaggerAppComponent.builder().applicationModule(ApplicationModule(this))
            .build()
    }*/

    @Override
    override fun onCreate(){
        super.onCreate()

        DaggerAppComponent.builder().applicationModule(ApplicationModule(this))
            .build().inject(this)
    }


    override fun androidInjector(): AndroidInjector<Any> {
        return dispatchingAndroidInjector
    }

}