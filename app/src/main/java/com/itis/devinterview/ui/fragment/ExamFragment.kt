package com.itis.devinterview.ui.fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.android.material.tabs.TabLayoutMediator
import com.itis.devinterview.R
import com.itis.devinterview.databinding.FragmentExamBinding
import com.itis.devinterview.model.Question
import com.itis.devinterview.preferences.AccessToRepository
import com.itis.devinterview.service.impl.QuestionServiceImpl
import com.itis.devinterview.ui.activity.ExamAdapter

open class ExamFragment : Fragment(R.layout.fragment_exam) {

    private var _binding: FragmentExamBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentExamBinding.bind(view)

        val pref = activity?.getSharedPreferences("TEST", Context.MODE_PRIVATE)
        if (pref != null) {
            AccessToRepository.getSP(pref)
        }
        val serviceImpl: QuestionServiceImpl = QuestionServiceImpl()
        serviceImpl.addQuestionList()

        val serviceImplForExam: QuestionServiceImpl = QuestionServiceImpl()
        val listOfQuestion = mutableListOf<String>()
        val textQuestion = serviceImplForExam.getRandomQuestion()
        for (i in 0 until listOfQuestion.size) {
            listOfQuestion.add(textQuestion.toString())
        }

        with(binding) {
            tvQuestion.text = textQuestion?.question
            btnFirstAns.text = textQuestion?.first
            btnSecondAns.text = textQuestion?.second
            btnThirdAns.text = textQuestion?.third
            btnFourthAns.text = textQuestion?.fourth
        }

    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}