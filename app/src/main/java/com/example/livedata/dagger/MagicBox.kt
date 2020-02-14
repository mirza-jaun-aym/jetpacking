package com.example.livedata.dagger

import dagger.Component

@Component(modules = [Bag::class])
interface MagicBox {
    fun poke(app: InjectionExperimentActivity)
}