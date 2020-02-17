package com.example.livedata.dagger

import com.example.livedata.list.ListAdapter
import com.example.livedata.list.User
import dagger.Module
import dagger.Provides

@Module
class AdapterModule {
    @Provides
    fun provideListAdapter() : ListAdapter = ListAdapter()
}