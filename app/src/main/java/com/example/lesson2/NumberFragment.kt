package com.example.lesson2

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lesson2.databinding.ContentNumberBinding

class NumberFragment: Fragment() {

    protected var binding: ContentNumberBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ContentNumberBinding.inflate(inflater)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val number = arguments?.getInt(EXTRAS_NUMBER) ?: -1
        binding?.number?.text = "$number"

        val color = when (number % 2 == 0) {
            true -> Color.RED
            false -> Color.BLUE
        }

        binding?.number?.setBackgroundColor(color)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {
        const val  EXTRAS_NUMBER = "EXTRAS_NUMBER"

        fun newInstance(number: Int): NumberFragment {
            val bundle = Bundle().apply {
                putInt(EXTRAS_NUMBER, number)
            }

            return NumberFragment().apply {
                arguments = bundle
            }
        }
    }
}