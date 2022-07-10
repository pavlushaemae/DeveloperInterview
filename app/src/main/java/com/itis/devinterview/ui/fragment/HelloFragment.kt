package com.itis.devinterview.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.itis.devinterview.R
import com.itis.devinterview.databinding.FragmentStartingBinding
import com.itis.devinterview.databinding.HelloFragmentBinding

class HelloFragment: Fragment(R.layout.hello_fragment) {
    private var _binding: HelloFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = HelloFragmentBinding.bind(view)

        with(binding) {
            btnHello.setOnClickListener {
                findNavController().navigate(R.id.action_helloFragment_to_nameFragment)
            }
        }

    }


    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}