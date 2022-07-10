package com.itis.devinterview.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.itis.devinterview.R
import com.itis.devinterview.databinding.FragmentStartingBinding

class StartingFragment: Fragment(R.layout.fragment_starting) {
    private var _binding: FragmentStartingBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentStartingBinding.bind(view)

        with(binding) {
            btnStarting.setOnClickListener {
                findNavController().navigate(R.id.action_startingFragment_to_helloFragment)
            }
        }

    }



    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}