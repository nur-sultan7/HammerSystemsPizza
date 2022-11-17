package com.example.hammersystemspizza.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.hammersystemspizza.data.database.PizzasInfoDao
import com.example.hammersystemspizza.data.mapper.PizzaMapper
import com.example.hammersystemspizza.data.network.ApiService
import com.example.hammersystemspizza.domain.PizzasRepository
import com.example.hammersystemspizza.domain.entities.ItemInfo
import javax.inject.Inject

class PizzasRepositoryImp @Inject constructor(
    private val apiService: ApiService,
    private val mapper: PizzaMapper,
    private val dao: PizzasInfoDao
) : PizzasRepository {

    override suspend fun loadPizzasAndDessertsData() {


    }

    override fun getPizzasData(): LiveData<List<ItemInfo>> {
        return Transformations.map(dao.getPizzasListAsc())
        { list ->
            list.map {
                mapper.pizzaInfoModelToEntity(it)
            }
        }
    }

    override fun getDessertsData(): LiveData<List<ItemInfo>> {
        return Transformations.map(dao.getDessertsListAsc())
        { list ->
            list.map {
                mapper.dessertInfoModelToEntity(it)
            }
        }
    }
}