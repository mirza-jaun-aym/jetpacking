package com.example.livedata.dagger

import com.example.livedata.MainActivity
import com.example.livedata.list.ListActivity
import com.example.livedata.list.ListFragment
import dagger.Component

@Component(modules = [AdapterModule::class])
interface AppComponent {
    fun inject(app: ListActivity)
    fun inject(fragment: ListFragment)
}