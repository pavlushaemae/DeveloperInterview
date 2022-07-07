package com.itis.devinterview.ui.fragment;

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.itis.devinterview.R
import com.itis.devinterview.databinding.FragmentSelectionLanguageBinding


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
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
