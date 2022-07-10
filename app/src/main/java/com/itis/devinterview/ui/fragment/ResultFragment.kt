package com.itis.devinterview.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.itis.devinterview.R
import com.itis.devinterview.databinding.FragmentResultBinding
import com.itis.devinterview.service.impl.QuestionServiceImpl

class ResultFragment : Fragment(R.layout.fragment_result) {
    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!
    private val questionService = QuestionServiceImpl()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentResultBinding.bind(view)
        val args by navArgs<ResultFragmentArgs>()
        val correctAnswers = args.answersArg
        val incorrectAnswers = args.incorrectAnswersArg
        val language = args.languageArg
        val idOfTick = args.idOfTicket
        if (language != null) {
            questionService.addOneTicket(language)
        }
        with(binding) {
            tvCorrectAnswers.text = "Количество правильных ответов: $correctAnswers"
            tvIncorrectAnswers.text = "Количество неправильных ответов: $incorrectAnswers"
            acbStartNewTest.setOnClickListener {
                findNavController().navigate(R.id.action_resultFragment_to_testing)
            }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val callback: OnBackPressedCallback =
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    findNavController().navigate(R.id.action_resultFragment_to_testing)
                }
            }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
    }
}