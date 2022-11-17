package com.example.hammersystemspizza.data.worker

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.WorkerParameters

interface InnerWorkerFactory {
    fun create(
        context: Context,
        workerParameters: WorkerParameters
    ): ListenableWorker
}