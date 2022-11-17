package com.example.hammersystemspizza.data.worker

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters
import com.example.hammersystemspizza.data.database.PizzasInfoDao
import com.example.hammersystemspizza.data.mapper.PizzaMapper
import com.example.hammersystemspizza.data.network.ApiService

class RefreshDataWorkerFactory(
    private val apiService: ApiService,
    private val mapper: PizzaMapper,
    private val dao: PizzasInfoDao
) : WorkerFactory() {
    override fun createWorker(
        appContext: Context,
        workerClassName: String,
        workerParameters: WorkerParameters,
    ): ListenableWorker {
        return RefreshDataWorker(
            appContext,
            workerParameters,
            apiService,
            mapper,
            dao
        )
    }
}