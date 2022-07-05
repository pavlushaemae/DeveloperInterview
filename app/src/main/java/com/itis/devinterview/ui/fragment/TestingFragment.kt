package com.itis.devinterview.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.itis.devinterview.R
import com.itis.devinterview.databinding.FragmentTestingBinding

class TestingFragment : Fragment(R.layout.fragment_testing) {
    private var _binding: FragmentTestingBinding? = null
    private val binding get() = _binding!!
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentTestingBinding.bind(view)
        with(binding) {
            btnTicket.setOnClickListener {
                findNavController().navigate(R.id.action_testing_to_selectionLanguage)
            }
            btnExam.setOnClickListener {
//                findNavController().navigate(R.id.)
            }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}