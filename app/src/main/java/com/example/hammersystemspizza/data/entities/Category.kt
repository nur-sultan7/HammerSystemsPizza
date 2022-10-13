package com.example.hammersystemspizza.data.entities

class Category(val name: String, vararg items: Item) {
    val listOfItems = items.toList()
}