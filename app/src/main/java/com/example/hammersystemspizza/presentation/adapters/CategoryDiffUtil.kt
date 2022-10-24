package com.example.hammersystemspizza.presentation.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.hammersystemspizza.domain.entities.Category

object CategoryDiffUtil: DiffUtil.ItemCallback<Category>() {
    override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem == newItem
    }
}