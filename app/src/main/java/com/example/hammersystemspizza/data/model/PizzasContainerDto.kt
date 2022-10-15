package com.example.hammersystemspizza.data.model

import com.google.gson.JsonObject
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PizzasContainerDto (
    @SerializedName("RAW")
    @Expose
    val json: JsonObject? = null
)
