package com.example.hammersystemspizza.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.hammersystemspizza.data.mapper.PizzaMapper
import com.example.hammersystemspizza.data.network.ApiFactory
import com.example.hammersystemspizza.data.repository.PizzasRepositoryImp
import com.example.hammersystemspizza.domain.usecases.LoadPizzasDataUseCase
import com.example.hammersystemspizza.data.database.AppDatabase
import kotlinx.coroutines.launch

class PizzasViewModel(application: Application) : AndroidViewModel(application) {
    private val apiService = ApiFactory.apiService
    private val mapper = PizzaMapper()
    private val database = AppDatabase.getInstance(application)
    private val repositoryImp = PizzasRepositoryImp(application, apiService, mapper, database)
    private val loadPizzasDataUseCase = LoadPizzasDataUseCase(repositoryImp)

    init {

    }

    fun loadPizzasData() {
        viewModelScope.launch {
            loadPizzasDataUseCase.invoke()
        }
    }
}