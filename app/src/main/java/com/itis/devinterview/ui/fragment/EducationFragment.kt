package com.itis.devinterview.ui.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.itis.devinterview.R
import com.itis.devinterview.databinding.FragmentEducationBinding
import com.itis.devinterview.ui.rv.Language
import com.itis.devinterview.ui.rv.LanguageAdapter
import com.itis.devinterview.ui.rv.LanguageRepository

private const val KEY_LAN = "ID"

class EducationFragment : Fragment(R.layout.fragment_education) {

    private var _binding: FragmentEducationBinding? = null
    private var languageAdapter: LanguageAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentEducationBinding.bind(view)
        initAdapter()
    }

    private fun initAdapter() {
        languageAdapter = LanguageAdapter(
            LanguageRepository.languages
        ) {
            navigate(it.id)
        }
        _binding?.let {
            it.recyclerView.adapter = languageAdapter
        }


    }

    private fun navigate(id: Int) {

        when (id) {
            0 -> findNavController().navigate(R.id.action_educationFragment_to_pythonFragment)
            1 -> findNavController().navigate(R.id.action_educationFragment_to_in_developing_fragment)
            2 -> findNavController().navigate(R.id.action_educationFragment_to_javaFragment)
            3 -> findNavController().navigate(R.id.action_educationFragment_to_in_developing_fragment)
            4 -> findNavController().navigate(R.id.action_educationFragment_to_in_developing_fragment)
        }


    }


}