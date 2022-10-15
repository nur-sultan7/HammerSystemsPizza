package com.example.hammersystemspizza.domain

import androidx.lifecycle.LiveData
import com.example.hammersystemspizza.data.database.model.PizzaInfoModel
import com.example.hammersystemspizza.domain.entities.PizzaInfo

interface PizzasRepository {
    suspend fun loadPizzasData()
    fun getPizzasData(): LiveData<List<PizzaInfo>>
}