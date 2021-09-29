package com.example.lesson2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson2.databinding.ItemItemBinding


class ItemAdapter(var listener: ItemHolder.IListener): RecyclerView.Adapter<ItemHolder>() {
    protected var count = 100

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val inflater = LayoutInflater.from(parent.context)
        val tmp = ItemItemBinding.inflate(inflater, parent, false)
        return ItemHolder(tmp, listener)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = count

    fun increment() {
        count++
        notifyItemInserted(count - 1)
    }
}