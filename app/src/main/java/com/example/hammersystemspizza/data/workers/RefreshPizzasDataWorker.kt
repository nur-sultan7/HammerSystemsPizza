package com.example.hammersystemspizza.data.workers

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkerParameters
import com.example.hammersystemspizza.data.mapper.PizzaMapper
import com.example.hammersystemspizza.data.network.ApiService
import kotlinx.coroutines.delay

class RefreshPizzasDataWorker(
    context: Context,
    workerParameters: WorkerParameters,
    private val apiService: ApiService,
    private val mapper: PizzaMapper
) : CoroutineWorker(context, workerParameters) {
    override suspend fun doWork(): Result {
        while (true) {
            try {
                val jsonContainer = apiService.getPizzasData()
               // val coinInfoListDto = mapper.mapJsonContainerToCoinInfoList(jsonContainer)
               // Log.d("LoadedData", coinInfoListDto.toString())
            } catch (e: Exception) {
                Log.d("LoadedData", e.toString())
            }
            delay(5_000)
        }
    }

    companion object {
        const val NAME = "RefreshPizzasDataWorker"
        fun makeRequest() =
            OneTimeWorkRequestBuilder<RefreshPizzasDataWorker>().build()
    }

}

