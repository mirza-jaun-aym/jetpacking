package com.example.livedata.dagger

import android.app.Application
import android.content.Context


import dagger.Module
import dagger.Provides

@Module
class ApplicationModule(private val application: Application) {

    @Provides
    @ApplicationContext
    internal fun provideApplicationContext(): Context {
        return application
    }
}
