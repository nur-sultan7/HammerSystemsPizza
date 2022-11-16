package com.example.hammersystemspizza.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hammersystemspizza.domain.entities.Category
import com.example.hammersystemspizza.domain.entities.ItemInfo
import com.example.hammersystemspizza.domain.usecases.GetDessertsDataUseCase
import com.example.hammersystemspizza.domain.usecases.GetPizzasDataUseCase
import com.example.hammersystemspizza.domain.usecases.LoadPizzasDataUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class PizzasViewModel @Inject constructor(
    private val loadPizzasDataUseCase: LoadPizzasDataUseCase,
    private val getPizzasDataUseCase: GetPizzasDataUseCase,
    private val getDessertsDataUseCase: GetDessertsDataUseCase
) : ViewModel() {

    init {
        viewModelScope.launch {
            loadPizzasDataUseCase.invoke()
        }
    }

    fun getPizzasData() = getPizzasDataUseCase.invoke()

    fun getDessertsData() = getDessertsDataUseCase.invoke()

    fun getCategory(categoryName: String, items: List<ItemInfo>): Category {
        return Category(
            categoryName,
            items
        )
    }
}