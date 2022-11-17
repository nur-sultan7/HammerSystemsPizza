package com.example.hammersystemspizza.presentation

import android.app.Application
import androidx.work.Configuration
import com.example.hammersystemspizza.data.database.AppDatabase
import com.example.hammersystemspizza.data.mapper.PizzaMapper
import com.example.hammersystemspizza.data.network.ApiFactory
import com.example.hammersystemspizza.data.worker.RefreshDataWorkerFactory
import com.example.hammersystemspizza.di.ApplicationComponent
import com.example.hammersystemspizza.di.DaggerApplicationComponent

class PizzasApp : Application(), Configuration.Provider {
    val component: ApplicationComponent by lazy {
        DaggerApplicationComponent.factory()
            .create(this)
    }

    override fun getWorkManagerConfiguration(): Configuration {
        return Configuration.Builder()
            .setWorkerFactory(
                RefreshDataWorkerFactory(
                    ApiFactory.apiService,
                    PizzaMapper(),
                    AppDatabase.getInstance(this).pizzasInfoDao()
                )
            )
            .build()
    }
}