package com.itis.devinterview.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.itis.devinterview.R
import com.itis.devinterview.databinding.FragmentTestingBinding
import com.itis.devinterview.preferences.AccessToRepository.getSP
import com.itis.devinterview.service.impl.QuestionServiceImpl

class TestingFragment : Fragment(R.layout.fragment_testing) {
    private var _binding: FragmentTestingBinding? = null
    private val binding get() = _binding!!
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentTestingBinding.bind(view)
        with(binding) {
            btnTicket.setOnClickListener {
                val action = TestingFragmentDirections.actionTestingToSelectionLanguage("Ticket")
                findNavController().navigate(action)
            }
            btnExam.setOnClickListener {
                val action = TestingFragmentDirections.actionTestingToSelectionLanguage("Exam")
                findNavController().navigate(action)
            }
        }
        val pref = activity?.getSharedPreferences("TEST", Context.MODE_PRIVATE)
        if (pref != null) {
            getSP(pref)
        }
        val serviceImpl = QuestionServiceImpl()
        serviceImpl.addQuestionList()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}