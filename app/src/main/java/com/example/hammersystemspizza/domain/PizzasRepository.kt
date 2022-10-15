package com.example.hammersystemspizza.domain

import com.example.hammersystemspizza.data.database.model.PizzaInfoModel

interface PizzasRepository {
    suspend fun loadPizzasData(): List<PizzaInfoModel>
}