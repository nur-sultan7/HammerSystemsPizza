package com.example.hammersystemspizza.di.modules

import com.example.hammersystemspizza.data.worker.InnerWorkerFactory
import com.example.hammersystemspizza.data.worker.RefreshPizzasDataWorker
import com.example.hammersystemspizza.di.keys.WorkerKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface WorkerModule {
    @Binds
    @IntoMap
    @WorkerKey(RefreshPizzasDataWorker::class)
    fun bindsRefreshDataWorkerFactory(factory: RefreshPizzasDataWorker.Factory): InnerWorkerFactory
}