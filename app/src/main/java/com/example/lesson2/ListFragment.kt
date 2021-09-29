package com.example.lesson2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.lesson2.databinding.ContentListBinding

class ListFragment: Fragment(), ItemHolder.IListener {
    protected var binding: ContentListBinding? = null
    protected var itemAdapter = ItemAdapter(this)

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

        binding?.recyclerView?.adapter = itemAdapter
        binding?.recyclerView?.layoutManager = GridLayoutManager(requireContext(), 3)

        binding?.fab?.setOnClickListener {
            addItem()
        }
    }

    private fun addItem() {
        itemAdapter.increment()
        binding?.recyclerView?.scrollToPosition(itemAdapter.itemCount - 1)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun onItemClicked(number: Int) {
        Toast.makeText(requireContext(), "position: $number", Toast.LENGTH_SHORT).show()

        parentFragmentManager.beginTransaction()
            .replace(R.id.container, NumberFragment.newInstance(number), "$number")
            .addToBackStack(null)
            .commit()
    }


}