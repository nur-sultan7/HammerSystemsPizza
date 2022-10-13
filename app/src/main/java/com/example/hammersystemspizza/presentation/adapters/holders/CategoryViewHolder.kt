package com.example.hammersystemspizza.presentation.adapters.holders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hammersystemspizza.databinding.ItemCategoryBinding

class CategoryViewHolder(private val binding: ItemCategoryBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun setData(content: String) {
        binding.tvItemName.text = content
    }

    companion object {
        fun create(view: ViewGroup): CategoryViewHolder {
            val viewBinding = ItemCategoryBinding.inflate(
                LayoutInflater.from(view.context),
                view,
                false
            )
            return CategoryViewHolder(viewBinding)
        }
    }
}