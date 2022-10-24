package com.example.hammersystemspizza.presentation.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hammersystemspizza.databinding.ItemCategoryBinding
import com.example.hammersystemspizza.domain.entities.Category

class CategoriesAdapter :
    RecyclerView.Adapter<CategoriesAdapter.CategoryViewHolder>() {
    private val _categoryList = mutableListOf<Category>()
    val categoryList: List<Category>
        get() = _categoryList

    @SuppressLint("NotifyDataSetChanged")
    fun addCategoryToList(category: Category) {
        _categoryList.add(category)
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun clearCategoryList() {
        _categoryList.clear()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categoryList[position]
        holder.bind(category)
    }

    class CategoryViewHolder(private val binding: ItemCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(category: Category) {
            binding.rvCategory.adapter = ItemsAdapter().apply {
                submitList(category.listOfItems)
            }
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

    override fun getItemCount(): Int {
       return categoryList.size
    }
}