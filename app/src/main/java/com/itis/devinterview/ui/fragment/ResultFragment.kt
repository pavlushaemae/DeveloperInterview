package com.itis.devinterview.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.itis.devinterview.R
import com.itis.devinterview.databinding.FragmentResultBinding

class ResultFragment: Fragment(R.layout.fragment_result) {
    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentResultBinding.bind(view)
        val args by navArgs<ResultFragmentArgs>()
        val correctAnswers = args.answersArg
        val incorrectAnswers = args.incorrectAnswersArg
        with(binding){
            tvCorrectAnswers.text = "Количество правильных ответов: $correctAnswers"
            tvIncorrectAnswers.text = "Количество неправильных ответов: $incorrectAnswers"
            acbStartNewTest.setOnClickListener {
                findNavController().navigate(R.id.action_resultFragment_to_testing)
            }
        }
    }
}