package com.example.hammersystemspizza.data.network

import com.example.hammersystemspizza.data.model.PizzaInfoDto
import com.example.hammersystemspizza.data.model.PizzasContainerDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiService {

    @Headers(
        "X-RapidAPI-Key: 5e0b24bb49msh4400a69fba1a878p1969d8jsnef1ce4004882",
        "X-RapidAPI-Host: pizza-and-desserts.p.rapidapi.com"
    )
    @GET("pizzas")
    suspend fun getPizzasData(): Array<PizzaInfoDto>

}