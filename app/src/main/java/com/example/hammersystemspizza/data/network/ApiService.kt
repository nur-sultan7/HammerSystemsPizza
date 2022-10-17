package com.example.hammersystemspizza.data.network

import com.example.hammersystemspizza.data.network.model.DessertInfoDto
import com.example.hammersystemspizza.data.network.model.PizzaInfoDto
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiService {
    companion object {
        const val API_KEY = "X-RapidAPI-Key: 26cd5b37f3mshbbff6e4e276a9fep19b222jsn9cd47b07c672"
        const val API_HOST = "X-RapidAPI-Host: pizza-and-desserts.p.rapidapi.com"
    }

    @Headers(API_KEY, API_HOST)
    @GET("pizzas")
    suspend fun getPizzasData(): Array<PizzaInfoDto>

    @Headers(API_KEY, API_HOST)
    @GET("desserts")
    suspend fun getDessertsData(): Array<DessertInfoDto>

}