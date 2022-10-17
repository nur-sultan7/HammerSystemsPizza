package com.example.hammersystemspizza.domain.entities

data class ItemInfo(
    val id: Int? = null,
    val name: String? = null,
    val price: Int? = null,
    val description: String? = null,
    val img: String? = null,
    val type: CategoryName = CategoryName.Pizza
)