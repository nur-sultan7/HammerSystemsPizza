package com.example.hammersystemspizza.domain.usecases

import com.example.hammersystemspizza.domain.PizzasRepository
import javax.inject.Inject

class LoadPizzasDataUseCase @Inject constructor(private val repository: PizzasRepository) {
    suspend operator fun invoke() {
        repository.loadPizzasAndDessertsData()
    }
}