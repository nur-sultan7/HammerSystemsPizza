package com.example.hammersystemspizza.presentation

import android.app.Application
import com.example.hammersystemspizza.di.ApplicationComponent
import com.example.hammersystemspizza.di.DaggerApplicationComponent

class PizzasApp : Application() {
    val component: ApplicationComponent by lazy {
        DaggerApplicationComponent.factory()
            .create(this)
    }
}