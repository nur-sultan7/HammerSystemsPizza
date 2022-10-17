package com.example.hammersystemspizza.data.network

import com.example.hammersystemspizza.data.network.model.DessertInfoDto
import com.example.hammersystemspizza.data.network.model.PizzaInfoDto
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiService {
    companion object {
        const val API_KEY = "X-RapidAPI-Key: 4843de36a6mshfe75341987235f9p1d69ffjsn55cc8e1da95d"
        const val API_HOST = "X-RapidAPI-Host: pizza-and-desserts.p.rapidapi.com"
    }

    @Headers(API_KEY, API_HOST)
    @GET("pizzas")
    suspend fun getPizzasData(): Array<PizzaInfoDto>

    @Headers(API_KEY, API_HOST)
    @GET("desserts")
    suspend fun getDessertsData(): Array<DessertInfoDto>

}