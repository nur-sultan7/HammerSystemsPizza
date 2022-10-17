package com.example.hammersystemspizza.domain.usecases

import com.example.hammersystemspizza.domain.PizzasRepository

class LoadPizzasDataUseCase(private val repository: PizzasRepository) {
    suspend operator fun invoke() {
        repository.loadPizzasAndDessertsData()
    }
}