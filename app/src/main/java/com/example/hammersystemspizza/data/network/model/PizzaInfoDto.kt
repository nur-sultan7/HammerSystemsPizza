package com.example.hammersystemspizza.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PizzaInfoDto(
    @SerializedName("id")
    @Expose
    val id: Int? = null,

    @SerializedName("name")
    @Expose
    val name: String? = null,

    @SerializedName("veg")
    @Expose
    val veg: Boolean? = null,

    @SerializedName("price")
    @Expose
    val price: Int? = null,

    @SerializedName("description")
    @Expose
    val description: String? = null,

    @SerializedName("quantity")
    @Expose
    val quantity: Int? = null,

    @SerializedName("img")
    @Expose
    val img: String? = null,
)