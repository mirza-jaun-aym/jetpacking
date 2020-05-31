package com.example.livedata.app

import com.example.livedata.dagger.ApplicationModule
import com.example.livedata.dagger.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject


open class MyApp  : DaggerApplication(),  HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun applicationInjector(): AndroidInjector<out MyApp> {
       return DaggerAppComponent.builder().applicationModule(ApplicationModule(this))
            .build()
    }

   /* override fun onCreate(){
        super.onCreate()

        DaggerAppComponent.builder().applicationModule(ApplicationModule(this))
            .build().inject(this)
    }


    override fun androidInjector(): AndroidInjector<Any> {
        return dispatchingAndroidInjector
    }*/

}