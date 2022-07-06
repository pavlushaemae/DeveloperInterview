package com.itis.devinterview.ui.fragment;

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.itis.devinterview.R
import com.itis.devinterview.databinding.FragmentSelectionLanguageBinding
import com.itis.devinterview.repository.impl.QuestionRepositoryImpl.getAllQuestions
import com.itis.devinterview.service.impl.QuestionServiceImpl

class SelectionLanguageFragment : Fragment(R.layout.fragment_selection_language) {
    private var _binding: FragmentSelectionLanguageBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSelectionLanguageBinding.bind(view)
        with(binding) {
            btnJava.setOnClickListener {
                findNavController().navigate(R.id.action_selectionLanguage_to_ticketsFragment)
            }
            btnPython.setOnClickListener {
                findNavController().navigate(R.id.action_selectionLanguage_to_ticketsFragment)
            }
            var list = getAllQuestions()
            Log.e(list.toString(), "ERROR")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
