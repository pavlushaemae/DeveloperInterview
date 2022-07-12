package com.itis.devinterview.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.itis.devinterview.R
import com.itis.devinterview.databinding.FragmentStartingBinding
import com.itis.devinterview.service.impl.QuestionServiceImpl


class StartingFragment : Fragment(com.itis.devinterview.R.layout.fragment_starting) {
    private var _binding: FragmentStartingBinding? = null
    private val binding get() = _binding!!
    private val service = QuestionServiceImpl()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentStartingBinding.bind(view)

        if (service.getFirstLaunch() ) {
            println(true)
            service.addFirstLaunch()
            with(binding) {
                btnStarting.setOnClickListener {
                    findNavController().navigate(com.itis.devinterview.R.id.action_startingFragment_to_helloFragment)
                }
            }
        }
        if (service.getFirstLaunch() == false) {
             findNavController().navigate(R.id.action_startingFragment_to_profile_fragment)
            println(false)
        }
        with(binding) {
            btnStarting.setOnClickListener {
                findNavController().navigate(com.itis.devinterview.R.id.action_startingFragment_to_helloFragment)
            }
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}