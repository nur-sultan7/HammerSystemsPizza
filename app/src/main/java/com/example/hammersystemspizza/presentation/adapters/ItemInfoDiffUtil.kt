package com.example.hammersystemspizza.presentation.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.hammersystemspizza.domain.entities.ItemInfo

object ItemInfoDiffUtil: DiffUtil.ItemCallback<ItemInfo>() {
    override fun areItemsTheSame(oldItem: ItemInfo, newItem: ItemInfo): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ItemInfo, newItem: ItemInfo): Boolean {
        return oldItem == newItem
    }
}