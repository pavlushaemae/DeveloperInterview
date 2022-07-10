package com.itis.devinterview.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.findNavController
import com.itis.devinterview.R
import com.itis.devinterview.databinding.FragmentNameBinding
import com.itis.devinterview.databinding.FragmentStartingBinding

class NameFragment: Fragment(R.layout.fragment_name) {
    private var _binding: FragmentNameBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentNameBinding.bind(view)

        with(binding) {
            btnName.setOnClickListener {
                findNavController().navigate(R.id.acti)
            }
        }

    }



    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}