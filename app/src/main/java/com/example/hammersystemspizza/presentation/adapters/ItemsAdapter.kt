package com.example.hammersystemspizza.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hammersystemspizza.R
import com.example.hammersystemspizza.databinding.ItemItemBinding
import com.example.hammersystemspizza.domain.entities.PizzaInfo
import com.squareup.picasso.Picasso


class ItemsAdapter(
    private var items: List<PizzaInfo>
) :
    RecyclerView.Adapter<ItemsAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ItemViewHolder(private val binding: ItemItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: PizzaInfo) {
            with(binding)
            {
                tvItemName.text = item.name
                tvDescription.text = item.description
                tvPrice.text = String.format(
                    binding.root.context.getString(R.string.price_txt),
                    item.price
                )
                Picasso.get()
                    .load(item.img)
                    .placeholder(R.drawable.img_default_pizza)
                    .into(ivItem)
            }
        }

        companion object {
            fun create(parent: ViewGroup): ItemViewHolder {
                return ItemViewHolder(
                    ItemItemBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
        }
    }
}