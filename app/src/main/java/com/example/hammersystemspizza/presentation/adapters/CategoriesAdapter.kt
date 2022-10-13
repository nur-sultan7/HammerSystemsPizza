package com.example.hammersystemspizza.presentation.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hammersystemspizza.data.entities.Category
import com.example.hammersystemspizza.presentation.adapters.holders.CategoryViewHolder

class CategoriesAdapter(private val listOfCategories : List<Category>) : RecyclerView.Adapter<CategoryViewHolder>(){
    lateinit var setOnDeleteListener: (id: Int) -> Unit
    lateinit var setOnItemClickListener: (note: Category) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder{
        return CategoryViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val item = listOfCategories[position]
        holder.setData(item.name)

    }

    override fun getItemCount(): Int {
        return listOfCategories.size
    }
}