package com.example.hammersystemspizza.domain.usecases

import androidx.lifecycle.LiveData
import com.example.hammersystemspizza.domain.PizzasRepository
import com.example.hammersystemspizza.domain.entities.ItemInfo
import javax.inject.Inject

class GetDessertsDataUseCase @Inject constructor(private val repository: PizzasRepository) {
    operator fun invoke(): LiveData<List<ItemInfo>> {
        return repository.getDessertsData()
    }
}