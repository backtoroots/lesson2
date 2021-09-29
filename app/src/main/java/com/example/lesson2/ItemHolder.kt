package com.example.lesson2

import android.graphics.Color
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson2.databinding.ItemItemBinding

class ItemHolder(val binding: ItemItemBinding, var listener: IListener): RecyclerView.ViewHolder(binding.root) {
    var item = 0

    init {
        binding.textView.setOnClickListener {
                listener.onItemClicked(item)
        }
    }

    fun bind(position: Int) {
        item = position
        binding.textView.text = "$position"

        val color = when (position % 2 == 0) {
            true -> Color.BLUE
            false -> Color.RED
        }
        binding.textView.setBackgroundColor(color)
    }

    interface IListener {
        fun onItemClicked(number: Int)
    }
}