package com.itis.devinterview.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.itis.devinterview.R
import com.itis.devinterview.databinding.FragmentHelloBinding
import com.itis.devinterview.databinding.FragmentStartingBinding


class HelloFragment: Fragment(R.layout.fragment_hello) {
    private var _binding: FragmentHelloBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHelloBinding.bind(view)

        with(binding) {
            btnHello.setOnClickListener {
                findNavController().navigate(R.id.action_helloFragment_to_profile_fragment)
            }
        }

    }


    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}