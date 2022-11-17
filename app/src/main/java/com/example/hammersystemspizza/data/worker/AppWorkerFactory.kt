package com.example.hammersystemspizza.data.worker

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters
import javax.inject.Inject
import javax.inject.Provider

class AppWorkerFactory @Inject constructor(
    private val workerProviders: @JvmSuppressWildcards Map<
            Class<out ListenableWorker>,
            Provider<InnerWorkerFactory>>
) : WorkerFactory() {
    override fun createWorker(
        appContext: Context,
        workerClassName: String,
        workerParameters: WorkerParameters,
    ): ListenableWorker? {
        return when (workerClassName) {
            RefreshPizzasDataWorker::class.qualifiedName ->
                workerProviders[RefreshPizzasDataWorker::class.java]
                    ?.get()
                    ?.create(appContext, workerParameters)
            RefreshDessertDataWorker::class.qualifiedName ->
                workerProviders[RefreshDessertDataWorker::class.java]
                    ?.get()
                    ?.create(appContext, workerParameters)
            else ->
                null
        }
    }
}