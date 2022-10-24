package com.example.hammersystemspizza.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.hammersystemspizza.R
import com.example.hammersystemspizza.databinding.ItemItemBinding
import com.example.hammersystemspizza.domain.entities.CategoryName
import com.example.hammersystemspizza.domain.entities.ItemInfo
import com.squareup.picasso.Picasso


class ItemsAdapter : ListAdapter<ItemInfo, ItemsAdapter.ItemViewHolder>(ItemInfoDiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ItemViewHolder(private val binding: ItemItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ItemInfo) {
            with(binding) {
                tvItemName.text = item.name
                tvDescription.text = item.description
                tvPrice.text = String.format(
                    binding.root.context.getString(R.string.price_txt), item.price
                )
                val placeholder = when (item.type) {
                    CategoryName.Pizza -> R.drawable.img_default_pizza
                    CategoryName.Dessert -> R.drawable.img_default_dessert
                }
                Picasso.get().load(item.img).placeholder(placeholder).into(ivItem)
            }
        }

        companion object {
            fun create(parent: ViewGroup): ItemViewHolder {
                return ItemViewHolder(
                    ItemItemBinding.inflate(
                        LayoutInflater.from(parent.context), parent, false
                    )
                )
            }
        }
    }
}