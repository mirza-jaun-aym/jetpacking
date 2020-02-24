package com.example.livedata.dagger

import com.example.livedata.app.MyApp
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@ApplicationScoped
@Component(
    modules = [AndroidSupportInjectionModule::class, FragmentModule::class, ActivityModule::class]
)
interface AppComponent : AndroidInjector<MyApp> {
}