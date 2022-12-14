package com.example.hammersystemspizza.di

import android.app.Application
import com.example.hammersystemspizza.di.modules.DataModule
import com.example.hammersystemspizza.di.modules.ViewModelModule
import com.example.hammersystemspizza.di.modules.WorkerModule
import com.example.hammersystemspizza.presentation.PizzasApp
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(modules = [DataModule::class, ViewModelModule::class, WorkerModule::class])
interface ApplicationComponent {

    fun mainActivityFactory(): MainActivityComponent.Factory

    fun inject(application: PizzasApp)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance
            application: Application
        ): ApplicationComponent
    }
}