package com.example.hammersystemspizza.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hammersystemspizza.databinding.ItemCategoryBinding
import com.example.hammersystemspizza.domain.entities.Category


class CategoriesAdapter : RecyclerView.Adapter<CategoriesAdapter.CategoryViewHolder>() {
    private var listOfCategories = mutableListOf<Category>()

    fun setListOfCategories(listOfCategories: List<Category>) {
        this.listOfCategories = listOfCategories.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = listOfCategories[position]
        holder.bind(category)
    }

    override fun getItemCount(): Int {
        return listOfCategories.size
    }

    class CategoryViewHolder(private val binding: ItemCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(category: Category) {
            binding.rvCategory.adapter = ItemsAdapter(category.listOfItems)
        }

        companion object {
            fun create(view: ViewGroup): CategoryViewHolder {
                val viewBinding = ItemCategoryBinding.inflate(
                    LayoutInflater.from(view.context), view, false
                )
                return CategoryViewHolder(viewBinding)
            }
        }
    }
}