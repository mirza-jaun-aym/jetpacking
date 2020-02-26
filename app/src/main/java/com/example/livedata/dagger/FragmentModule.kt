package com.example.livedata.dagger

import com.example.livedata.auth.LoginFragment
import com.example.livedata.list.ui.listother.ListOtherFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun contributeListFragment(): ListOtherFragment

    @ContributesAndroidInjector
    abstract fun contributeLoginFragment(): LoginFragment

}