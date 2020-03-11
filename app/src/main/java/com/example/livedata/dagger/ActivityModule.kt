package com.example.livedata.dagger

import com.example.livedata.auth.AuthActivity
import com.example.livedata.list.ListActivity
import com.example.livedata.splash.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeScanPointActivityInjector(): ListActivity

    @ContributesAndroidInjector
    abstract fun contributeSplashActivityInjector(): SplashActivity

    @ContributesAndroidInjector
    abstract fun contributeAuthActivityInjector(): AuthActivity
}