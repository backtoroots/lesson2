package com.example.lesson2

import android.graphics.Color
import android.os.Bundle
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson2.databinding.ContentListBinding
import com.example.lesson2.databinding.ItemItemBinding

class ListFragment: Fragment() {
    protected var binding: ContentListBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ContentListBinding.inflate(layoutInflater)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.recyclerView?.adapter = ItemAdapter()
        binding?.recyclerView?.layoutManager = GridLayoutManager(requireContext(), 3)

        binding?.fab?.setOnClickListener {
            addItem()
        }
    }

    private fun addItem() {
//        val adapter = (binding?.recycler?.adapter as ItemAdapter).increment()
//        binding?.recycler.scrollToPosition(adapter.counter)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    class ItemHolder(val binding: ItemItemBinding): RecyclerView.ViewHolder(binding.root) {
        var item = 0

        init {
            binding.textView.setOnClickListener {
//                listener.onItemSelected(item)
            }
        }

        fun bind(position: Int) {
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

//    class ItemAdapter(var listener: ItemHolder.IListener): RecyclerView.Adapter<ItemHolder>() {
    class ItemAdapter(): RecyclerView.Adapter<ItemHolder>() {
        var counter = 100

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
            val inflater = LayoutInflater.from(parent.context)
            val tmp = ItemItemBinding.inflate(inflater, parent, false)
            return ItemHolder(tmp)
        }

        override fun onBindViewHolder(holder: ItemHolder, position: Int) {
            holder.bind(position)
        }

        override fun getItemCount(): Int = counter

        fun increment() {
            counter++
            notifyItemInserted(counter - 1)
        }
    }
}