package com.example.hammersystemspizza.data

import com.example.hammersystemspizza.data.entities.Category
import com.example.hammersystemspizza.data.entities.Item

object ContentData {
    fun getData():List<Category>{
        return mutableListOf(
            Category(
                "Category 1",
                Item("Item 1"),
                Item("Item 2"),
                Item("Item 3"),
                Item("Item 4"),
                Item("Item 5"),
                Item("Item 6"),
                Item("Item 11"),
                Item("Item 21"),
                Item("Item 31"),
                Item("Item 41"),
                Item("Item 51"),
                Item("Item 61")
            ),
            Category(
                "Category 2",
                Item("Item 1"),
                Item("Item 2"),
                Item("Item 3"),
                Item("Item 4"),
                Item("Item 5"),
                Item("Item 6")
            ),
            Category(
                "Category 3",
                Item("Item 1"),
                Item("Item 2"),
                Item("Item 3"),
                Item("Item 4"),
                Item("Item 5"),
                Item("Item 6")
            ),
            Category(
                "Category 4",
                Item("Item 1"),
                Item("Item 2"),
                Item("Item 3"),
                Item("Item 4"),
                Item("Item 5"),
                Item("Item 6")
            ),

            Category(
                "Category 5",
                Item("Item 1"),
                Item("Item 2"),
                Item("Item 4"),
                Item("Item 5"),
            ),
            Category(
                "Category 5",
                Item("Item 1"),
                Item("Item 2"),
                Item("Item 4"),
                Item("Item 5"),
            ),
            Category(
                "Category 5",
                Item("Item 1"),
                Item("Item 2"),
                Item("Item 4"),
                Item("Item 5"),
            ),
            Category(
                "Category 5",
                Item("Item 1"),
                Item("Item 2"),
                Item("Item 4"),
                Item("Item 5"),
            ),
            Category(
                "Category 5",
                Item("Item 1"),
                Item("Item 2"),
                Item("Item 4"),
                Item("Item 5"),
            ),
            Category(
                "Category 5",
                Item("Item 1"),
                Item("Item 2"),
                Item("Item 4"),
                Item("Item 5"),
            ),
            Category(
                "Category 5",
                Item("Item 1"),
                Item("Item 2"),
                Item("Item 4"),
                Item("Item 5"),
            ),
            Category(
                "Category 5",
                Item("Item 1"),
                Item("Item 2"),
                Item("Item 4"),
                Item("Item 5"),
            ),
        )
    }
}