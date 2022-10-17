package com.example.hammersystemspizza.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hammersystemspizza.databinding.ItemCategoryBinding
import com.example.hammersystemspizza.domain.entities.Category


class CategoriesAdapter : RecyclerView.Adapter<CategoriesAdapter.CategoryViewHolder>() {
    private var _listOfCategories = mutableListOf<Category>()
    val listOfCategories: List<Category>
        get() = _listOfCategories

    fun addCategoryToList(category: Category) {
        this._listOfCategories.add(category)
        notifyDataSetChanged()
    }

    fun clearCategoryList() {
        _listOfCategories.clear()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = _listOfCategories[position]
        holder.bind(category)
    }

    override fun getItemCount(): Int {
        return _listOfCategories.size
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