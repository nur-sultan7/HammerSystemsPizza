package com.example.hammersystemspizza.data.network

import com.example.hammersystemspizza.data.model.PizzaInfoDto
import com.example.hammersystemspizza.data.model.PizzasContainerDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiService {

    @Headers(
        "X-RapidAPI-Key: c342e2d9cbmshd2b60fa37178413p13dc4djsn7998f70fdddc",
        "X-RapidAPI-Host: pizza-and-desserts.p.rapidapi.com"
    )
    @GET("pizzas")
    suspend fun getPizzasData(): Array<PizzaInfoDto>

}