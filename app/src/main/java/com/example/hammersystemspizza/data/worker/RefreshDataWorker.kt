package com.example.hammersystemspizza.data.worker

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters

class RefreshDataWorker(
   context: Context,
   workerParameters: WorkerParameters
): CoroutineWorker(context, workerParameters) {
    override suspend fun doWork(): Result {
        TODO("Not yet implemented")
    }
}