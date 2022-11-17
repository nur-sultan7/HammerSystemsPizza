package com.example.hammersystemspizza.data.worker

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.ListenableWorker
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkerParameters
import com.example.hammersystemspizza.data.database.PizzasInfoDao
import com.example.hammersystemspizza.data.mapper.PizzaMapper
import com.example.hammersystemspizza.data.network.ApiService
import javax.inject.Inject

class RefreshPizzasDataWorker(
    context: Context,
    workerParameters: WorkerParameters,
    private val apiService: ApiService,
    private val mapper: PizzaMapper,
    private val dao: PizzasInfoDao
) : CoroutineWorker(context, workerParameters) {
    override suspend fun doWork(): Result {
        try {
            val listOfPizzaInfoDto = apiService.getPizzasData().toList()
            dao.insertPizzasInfoList(mapper.listPizzaInfoDtoToModel(listOfPizzaInfoDto))
        } catch (e: Exception) {
            Log.d("Pizzas Loading Exception:", e.toString())
        }
        return Result.success()
    }

    companion object {
        const val NAME = "Refresh pizzas data worker"
        const val ONE_HOUR_IN_MILLIS = 3_600_000L
        fun makeRequest() = OneTimeWorkRequestBuilder<RefreshPizzasDataWorker>()
            .build()
    }

    class Factory @Inject constructor(
        private val apiService: ApiService,
        private val mapper: PizzaMapper,
        private val dao: PizzasInfoDao
    ) : InnerWorkerFactory {
        override fun create(
            context: Context,
            workerParameters: WorkerParameters
        ): ListenableWorker {
            return RefreshPizzasDataWorker(
                context, workerParameters, apiService, mapper, dao
            )
        }
    }
}