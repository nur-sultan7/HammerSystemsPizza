package com.example.hammersystemspizza.data.repository

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.work.ExistingWorkPolicy
import androidx.work.WorkManager
import com.example.hammersystemspizza.data.database.model.PizzaInfoModel
import com.example.hammersystemspizza.data.mapper.PizzaMapper
import com.example.hammersystemspizza.data.network.ApiService
import com.example.hammersystemspizza.data.workers.RefreshPizzasDataWorker
import com.example.hammersystemspizza.domain.PizzasRepository
import com.example.hammersystemspizza.data.database.AppDatabase
import com.example.hammersystemspizza.data.database.PizzasInfoDao
import com.example.hammersystemspizza.domain.entities.PizzaInfo

class PizzasRepositoryImp(
    private val application: Application,
    private val apiService: ApiService,
    private val mapper: PizzaMapper,
    private val dao: PizzasInfoDao
) : PizzasRepository {

    fun loadPizzasDataWorker() {
        val workerManager = WorkManager.getInstance(application)
        workerManager.enqueueUniqueWork(
            RefreshPizzasDataWorker.NAME,
            ExistingWorkPolicy.REPLACE,
            RefreshPizzasDataWorker.makeRequest()
        )
    }

    override suspend fun loadPizzasData() {

        try {
            val listOfPizzaInfoDto = apiService.getPizzasData().toList()
            dao.insertPizzasInfoList(mapper.listPizzaInfoDtoToModel(listOfPizzaInfoDto))
        } catch (e: Exception) {
            Log.d("Pizzas Loading Exception:", e.toString())
        }
    }

    override fun getPizzasData(): LiveData<List<PizzaInfo>> {
        return Transformations.map(dao.getPizzasListAsc())
        { list ->
            list.map {
                mapper.pizzaInfoModelToEntity(it)
            }
        }
    }
}