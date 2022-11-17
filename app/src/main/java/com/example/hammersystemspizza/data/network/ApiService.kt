package com.example.hammersystemspizza.data.network

import com.example.hammersystemspizza.data.network.model.DessertInfoDto
import com.example.hammersystemspizza.data.network.model.PizzaInfoDto
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiService {
    companion object {
        const val API_KEY = "X-RapidAPI-Key: 10bd0a786emshb5ad72fd0dcb6e6p14f1cajsn20ffe75d6a3e"
        const val API_HOST = "X-RapidAPI-Host: pizza-and-desserts.p.rapidapi.com"
    }

    @Headers(API_KEY, API_HOST)
    @GET("pizzas")
    suspend fun getPizzasData(): Array<PizzaInfoDto>

    @Headers(API_KEY, API_HOST)
    @GET("desserts")
    suspend fun getDessertsData(): Array<DessertInfoDto>

}