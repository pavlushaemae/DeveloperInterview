package com.itis.devinterview.ui.fragment

import android.content.Context
import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.View
import com.itis.devinterview.R
import com.itis.devinterview.databinding.FragmentExamBinding
import com.itis.devinterview.preferences.AccessToRepository
import com.itis.devinterview.service.impl.QuestionServiceImpl

open class ExamFragment : Fragment(R.layout.fragment_exam) {

    private var timer: CountDownTimer? = null
    private var _binding: FragmentExamBinding? = null
    private val binding get() = _binding!!


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentExamBinding.bind(view)

        startCountDownTimer(5*60*1000)

        val pref = activity?.getSharedPreferences("TEST", Context.MODE_PRIVATE)
        if (pref != null) {
            AccessToRepository.getSP(pref)
        }

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

    private fun startCountDownTimer(timeMillis: Long) {
        timer?.cancel()
        timer = object : CountDownTimer(timeMillis, 1000){
            override fun onTick(millisUntilFinished: Long) {
                binding.tvTimer.text = millisUntilFinished.toString()
            }

            override fun onFinish() {
                binding.tvTimer.text = "Finish"
            }
        }.start()
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()

    }
}