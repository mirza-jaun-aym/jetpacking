package com.example.livedata.dagger

import com.example.livedata.list.ListActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeScanPointActivityInjector(): ListActivity
}