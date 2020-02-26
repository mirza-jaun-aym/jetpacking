package com.example.livedata.dagger

import com.example.livedata.app.MyApp
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule


@ApplicationScoped
@Component(
    modules = [AndroidSupportInjectionModule::class, FragmentModule::class, ActivityModule::class, ApplicationModule::class]
)
interface AppComponent : AndroidInjector<MyApp> {
}