package com.example.hammersystemspizza.domain

import androidx.lifecycle.LiveData
import com.example.hammersystemspizza.domain.entities.ItemInfo

interface PizzasRepository {
    suspend fun loadPizzasAndDessertsData()
    fun getPizzasData(): LiveData<List<ItemInfo>>
    fun getDessertsData(): LiveData<List<ItemInfo>>
}