package com.example.hammersystemspizza.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pizzas_list")
open class PizzaInfoModel(
    @PrimaryKey
    val id: Int? = null,

    val name: String? = null,

    val price: Int? = null,

    val description: String? = null,

    val img: String? = null,
)
