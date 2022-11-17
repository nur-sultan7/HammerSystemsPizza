package com.example.hammersystemspizza.di.keys

import androidx.work.ListenableWorker
import dagger.MapKey
import kotlin.reflect.KClass

@MapKey
@Retention(AnnotationRetention.RUNTIME)
annotation class WorkerKey(val kotlinClass: KClass<out ListenableWorker>)
