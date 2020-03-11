package com.example.livedata.dagger

import com.example.livedata.MainActivity
import com.example.livedata.list.ListActivity
import dagger.Component

@Component(modules = [Bag::class,AdapterModule::class])
interface AppComponent {
    fun inject(app: InjectionExperimentActivity)
    fun inject(app: ListActivity)
}