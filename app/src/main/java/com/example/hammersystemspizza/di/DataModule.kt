package com.example.hammersystemspizza.di

import android.app.Application
import com.example.hammersystemspizza.data.database.AppDatabase
import com.example.hammersystemspizza.data.database.PizzasInfoDao
import com.example.hammersystemspizza.data.network.ApiFactory
import com.example.hammersystemspizza.data.network.ApiService
import com.example.hammersystemspizza.data.repository.PizzasRepositoryImp
import com.example.hammersystemspizza.domain.PizzasRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {
    @Binds
    fun bindsPizzasRepository(imp: PizzasRepositoryImp): PizzasRepository

    companion object {

        @ApplicationScope
        @Provides
        fun provideApiService(): ApiService {
            return ApiFactory.apiService
        }

        @ApplicationScope
        @Provides
        fun providePizzaInfoDao(application: Application): PizzasInfoDao {
            return AppDatabase.getInstance(application).pizzasInfoDao()
        }
    }
}