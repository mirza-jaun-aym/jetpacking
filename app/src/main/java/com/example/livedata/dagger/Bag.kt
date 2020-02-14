package com.example.livedata.dagger

import dagger.Module
import dagger.Provides

@Module
class Bag {
    @Provides
    open fun sayLoveDagger2(): Info {
        return Info("Love Dagger 2")
    }
}