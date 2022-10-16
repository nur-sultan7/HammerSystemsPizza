package com.example.hammersystemspizza.data.network

import com.example.hammersystemspizza.data.model.PizzaInfoDto
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiService {

    @Headers(
        "X-RapidAPI-Key: f0502f1283msh87f20c119074be9p13a267jsndb1b2593519d",
        "X-RapidAPI-Host: pizza-and-desserts.p.rapidapi.com"
    )
    @GET("pizzas")
    suspend fun getPizzasData(): Array<PizzaInfoDto>

}