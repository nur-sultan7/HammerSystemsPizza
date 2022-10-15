package com.example.hammersystemspizza.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.hammersystemspizza.data.database.AppDatabase
import com.example.hammersystemspizza.data.mapper.PizzaMapper
import com.example.hammersystemspizza.data.network.ApiFactory
import com.example.hammersystemspizza.data.repository.PizzasRepositoryImp
import com.example.hammersystemspizza.domain.entities.Category
import com.example.hammersystemspizza.domain.entities.PizzaInfo
import com.example.hammersystemspizza.domain.usecases.GetPizzasDataUseCase
import com.example.hammersystemspizza.domain.usecases.LoadPizzasDataUseCase
import kotlinx.coroutines.launch

class PizzasViewModel(application: Application) : AndroidViewModel(application) {
    private val apiService = ApiFactory.apiService
    private val mapper = PizzaMapper()
    private val dao = AppDatabase.getInstance(application).pizzasInfoDao()
    private val repositoryImp = PizzasRepositoryImp(application, apiService, mapper, dao)
    private val loadPizzasDataUseCase = LoadPizzasDataUseCase(repositoryImp)
    private val getPizzasDataUseCase = GetPizzasDataUseCase(repositoryImp)
    val categoriesItems = mutableListOf<Category>()

    init {
        viewModelScope.launch {
            loadPizzasDataUseCase.invoke()
        }
    }

    @JvmName("getPizzasData1")
    fun getPizzasData() = getPizzasDataUseCase.invoke()

    fun putItemsInCategory(categoryName: String, items: List<PizzaInfo>): List<Category> {
        categoriesItems.add(
            Category(
                categoryName,
                items
            )
        )
        return categoriesItems
    }
}