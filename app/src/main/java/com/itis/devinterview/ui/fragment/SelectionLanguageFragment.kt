package com.itis.devinterview.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.itis.devinterview.R
import com.itis.devinterview.databinding.FragmentSelectionLanguageBinding

class SelectionLanguageFragment : Fragment(R.layout.fragment_selection_language) {
    private var _binding: FragmentSelectionLanguageBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSelectionLanguageBinding.bind(view)
        val args by navArgs<SelectionLanguageFragmentArgs>()
        val typeOfTesting = args.typeOfTestingArg
        with(binding) {
            if(typeOfTesting == "Ticket") {
                btnJava.setOnClickListener {
                    val action = SelectionLanguageFragmentDirections
                        .actionSelectionLanguageToTicketsFragment("Java")
                    findNavController().navigate(action)
                }
                btnPython.setOnClickListener {
                    val action = SelectionLanguageFragmentDirections
                        .actionSelectionLanguageToTicketsFragment("Python")
                    findNavController().navigate(action)
                }
                btnCPlusPlus.setOnClickListener {
                    findNavController().navigate(R.id.action_selectionLanguage_to_inDevelopingFragment)
                }
                btnKotlin.setOnClickListener {
                    findNavController().navigate(R.id.action_selectionLanguage_to_inDevelopingFragment)
                }
                btnPhp.setOnClickListener {
                    findNavController().navigate(R.id.action_selectionLanguage_to_inDevelopingFragment)
                }
            }else if (typeOfTesting == "Exam"){
                btnJava.setOnClickListener {
                    val action = SelectionLanguageFragmentDirections
                        .actionSelectionLanguageToSecondaryExamFragment("Java")
                    findNavController().navigate(action)
                }
                btnPython.setOnClickListener {
                    val action = SelectionLanguageFragmentDirections
                        .actionSelectionLanguageToSecondaryExamFragment("Python")
                    findNavController().navigate(action)
                }
                btnCPlusPlus.setOnClickListener {
                    findNavController().navigate(R.id.action_selectionLanguage_to_inDevelopingFragment)
                }
                btnKotlin.setOnClickListener {
                    findNavController().navigate(R.id.action_selectionLanguage_to_inDevelopingFragment)
                }
                btnPhp.setOnClickListener {
                    findNavController().navigate(R.id.action_selectionLanguage_to_inDevelopingFragment)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
