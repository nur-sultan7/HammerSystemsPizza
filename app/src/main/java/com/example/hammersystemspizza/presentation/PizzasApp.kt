package com.example.hammersystemspizza.presentation

import android.app.Application
import androidx.work.Configuration
import com.example.hammersystemspizza.data.worker.AppWorkerFactory
import com.example.hammersystemspizza.di.ApplicationComponent
import com.example.hammersystemspizza.di.DaggerApplicationComponent
import javax.inject.Inject

class PizzasApp : Application(), Configuration.Provider {

    @Inject
    lateinit var workerFactory: AppWorkerFactory

   val component: ApplicationComponent by lazy {
        DaggerApplicationComponent.factory()
            .create(this)
    }



    override fun onCreate() {
        component.inject(this)
        super.onCreate()
    }

    override fun getWorkManagerConfiguration(): Configuration {
        return Configuration.Builder()
            .setWorkerFactory(workerFactory)
            .build()
    }
}