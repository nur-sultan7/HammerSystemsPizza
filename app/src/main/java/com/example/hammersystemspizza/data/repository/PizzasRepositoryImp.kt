package com.example.hammersystemspizza.data.repository

import android.app.Application
import android.util.Log
import androidx.work.ExistingWorkPolicy
import androidx.work.WorkManager
import com.example.hammersystemspizza.data.database.model.PizzaInfoModel
import com.example.hammersystemspizza.data.mapper.PizzaMapper
import com.example.hammersystemspizza.data.network.ApiService
import com.example.hammersystemspizza.data.workers.RefreshPizzasDataWorker
import com.example.hammersystemspizza.domain.PizzasRepository
import com.example.hammersystemspizza.data.database.AppDatabase

class PizzasRepositoryImp(
    private val application: Application,
    private val apiService: ApiService,
    private val mapper: PizzaMapper,
    private val database: AppDatabase
) : PizzasRepository {

    fun loadPizzasDataWorker() {
        val workerManager = WorkManager.getInstance(application)
        workerManager.enqueueUniqueWork(
            RefreshPizzasDataWorker.NAME,
            ExistingWorkPolicy.REPLACE,
            RefreshPizzasDataWorker.makeRequest()
        )
    }

    override suspend fun loadPizzasData(): List<PizzaInfoModel> {

        try {
            val listOfPizzaInfoDto = apiService.getPizzasData().toList()
            database.pizzasInfoDao()
                .insertPizzasInfoList(mapper.listPizzaInfoDtoToModel(listOfPizzaInfoDto))
        } catch (e: Exception) {
            Log.d("Pizzas Loading Exception:", e.toString())
        }
        return emptyList()
    }
}