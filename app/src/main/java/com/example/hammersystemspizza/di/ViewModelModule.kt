package com.example.hammersystemspizza.di

import androidx.lifecycle.ViewModel
import com.example.hammersystemspizza.presentation.PizzasViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {
    @IntoMap
    @Binds
    @ViewModelKey(PizzasViewModel::class)
    fun bindPizzasViewModel(impl: PizzasViewModel): ViewModel
}