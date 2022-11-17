package com.example.hammersystemspizza.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.work.ExistingWorkPolicy
import androidx.work.WorkManager
import com.example.hammersystemspizza.data.database.PizzasInfoDao
import com.example.hammersystemspizza.data.mapper.PizzaMapper
import com.example.hammersystemspizza.data.worker.RefreshDessertDataWorker
import com.example.hammersystemspizza.data.worker.RefreshPizzasDataWorker
import com.example.hammersystemspizza.domain.PizzasRepository
import com.example.hammersystemspizza.domain.entities.ItemInfo
import javax.inject.Inject

class PizzasRepositoryImp @Inject constructor(
    private val mapper: PizzaMapper,
    private val dao: PizzasInfoDao,
    private val workManager: WorkManager
) : PizzasRepository {


    override suspend fun loadPizzasAndDessertsData() {
        workManager.enqueueUniqueWork(
            RefreshPizzasDataWorker.NAME,
            ExistingWorkPolicy.REPLACE,
            RefreshPizzasDataWorker.makeRequest()
        )
        workManager.enqueueUniqueWork(
            RefreshDessertDataWorker.NAME,
            ExistingWorkPolicy.REPLACE,
            RefreshDessertDataWorker.makeRequest()
        )
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