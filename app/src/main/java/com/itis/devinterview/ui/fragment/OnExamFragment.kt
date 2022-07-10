package com.itis.devinterview.ui.fragment

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.Chronometer
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.itis.devinterview.R.*
import com.itis.devinterview.databinding.FragmentOnExamBinding
import com.itis.devinterview.model.Question
import com.itis.devinterview.service.impl.QuestionServiceImpl


class OnExamFragment: Fragment(layout.fragment_on_exam) {
    private var _binding: FragmentOnExamBinding? = null
    private val binding get() = _binding!!
    private val questionServiceImpl = QuestionServiceImpl()
    private lateinit var questionTimer: Chronometer
    private var currentQuestionPosition = 0
    private var selectedOptionByUser = ""
    private lateinit var listOfQuestions: List<Question>
    private var correctAnswers = 0;

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentOnExamBinding.bind(view)
        val args by navArgs<OnExamFragmentArgs>()
        val language = args.languageArg
        listOfQuestions = questionServiceImpl.getTenRandomQuestions(language)
        startTimer(180)
        with(binding) {
            tvQuestions.text = "${currentQuestionPosition+1}/${listOfQuestions.size}"
            tvQuestion.text = listOfQuestions[0].question
            acbOptionFirst.text = listOfQuestions[0].first
            acbOptionSecond.text = listOfQuestions[0].second
            acbOptionThird.text = listOfQuestions[0].third
            acbOptionFourth.text = listOfQuestions[0].fourth
            acbOptionFirst.setOnClickListener {
                if(selectedOptionByUser.isEmpty()) {
                    selectedOptionByUser = acbOptionFirst.text.toString()
                    if (selectedOptionByUser == listOfQuestions[currentQuestionPosition].correct) {
                        correctAnswers++;
                    }
                    acbOptionFirst.setBackgroundResource(drawable.round_back_dark_blue_10)
                    acbOptionFirst.setTextColor(Color.WHITE)
//                    revealAnswer()
                }
            }
            acbOptionSecond.setOnClickListener {
                if(selectedOptionByUser.isEmpty()) {
                    selectedOptionByUser = acbOptionSecond.text.toString()
                    if (selectedOptionByUser == listOfQuestions[currentQuestionPosition].correct) {
                        correctAnswers++;
                    }
                    acbOptionSecond.setBackgroundResource(drawable.round_back_dark_blue_10)
                    acbOptionSecond.setTextColor(Color.WHITE)
//                    revealAnswer()
                }
            }
            acbOptionThird.setOnClickListener {
                if(selectedOptionByUser.isEmpty()) {
                    selectedOptionByUser = acbOptionThird.text.toString()
                    if (selectedOptionByUser == listOfQuestions[currentQuestionPosition].correct) {
                        correctAnswers++;
                    }
                    acbOptionThird.setBackgroundResource(drawable.round_back_dark_blue_10)
                    acbOptionThird.setTextColor(Color.WHITE)
//                    revealAnswer()
                }
            }
            acbOptionFourth.setOnClickListener {
                if(selectedOptionByUser.isEmpty()) {
                    selectedOptionByUser = acbOptionFourth.text.toString()
                    if (selectedOptionByUser == listOfQuestions[currentQuestionPosition].correct) {
                        correctAnswers++;
                    }
                    acbOptionFourth.setBackgroundResource(drawable.round_back_dark_blue_10)
                    acbOptionFourth.setTextColor(Color.WHITE)
//                    revealAnswer()
                }
            }
            btnNext.setOnClickListener {
                if(selectedOptionByUser.isEmpty()) {
                    Toast.makeText(context,"Выберите правильный ответ", Toast.LENGTH_SHORT).show()
                } else {
                    changeNextQuestion()
                }
            }
        }
    }

    private fun startTimer(time: Int) {
        questionTimer = binding.tvTimer
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            questionTimer.isCountDown = true
        }
        questionTimer.base = SystemClock.elapsedRealtime() + time * 1000
        questionTimer.start()
        questionTimer.setOnChronometerTickListener {
            if (questionTimer.text.toString() == "00:00" || questionTimer.text.toString()[3] == ':') {
                questionTimer.stop()

                Toast.makeText(context, "Время вышло", Toast.LENGTH_SHORT)
                val action = OnExamFragmentDirections.actionOnExamFragmentToResultFragment(correctAnswers, 10 - correctAnswers)
                findNavController().navigate(action)
            }
        }
    }

//    private fun revealAnswer() {
//        val getAnswer = listOfQuestions[currentQuestionPosition].correct
//        if(binding.acbOptionFirst.text.toString() == getAnswer) {
//            binding.acbOptionFirst.setBackgroundResource(drawable.round_back_green_10)
//            binding.acbOptionFirst.setTextColor(Color.WHITE)
//        }else if (binding.acbOptionSecond.text.toString() == getAnswer) {
//            binding.acbOptionSecond.setBackgroundResource(drawable.round_back_green_10)
//            binding.acbOptionSecond.setTextColor(Color.WHITE)
//        }else if (binding.acbOptionThird.text.toString() == getAnswer) {
//            binding.acbOptionThird.setBackgroundResource(drawable.round_back_green_10)
//            binding.acbOptionThird.setTextColor(Color.WHITE)
//        }else if (binding.acbOptionFourth.text.toString() == getAnswer) {
//            binding.acbOptionFourth.setBackgroundResource(drawable.round_back_green_10)
//            binding.acbOptionFourth.setTextColor(Color.WHITE)
//        }
//    }

    private fun changeNextQuestion() {
        currentQuestionPosition++
        if ((currentQuestionPosition + 1 ) == listOfQuestions.size) {
            binding.btnNext.text = "Готово"
        }
        if (currentQuestionPosition < listOfQuestions.size) {
            selectedOptionByUser = ""
            with(binding) {
                acbOptionFirst.setBackgroundResource(drawable.round_back_white_stroke)
                acbOptionFirst.setTextColor(Color.parseColor("#FF000000"))
                acbOptionSecond.setBackgroundResource(drawable.round_back_white_stroke)
                acbOptionSecond.setTextColor(Color.parseColor("#FF000000"))
                acbOptionThird.setBackgroundResource(drawable.round_back_white_stroke)
                acbOptionThird.setTextColor(Color.parseColor("#FF000000"))
                acbOptionFourth.setBackgroundResource(drawable.round_back_white_stroke)
                acbOptionFourth.setTextColor(Color.parseColor("#FF000000"))
                tvQuestions.text = "${currentQuestionPosition + 1}/${listOfQuestions.size}"
                tvQuestion.text = listOfQuestions[currentQuestionPosition].question
                acbOptionFirst.text = listOfQuestions[currentQuestionPosition].first
                acbOptionSecond.text = listOfQuestions[currentQuestionPosition].second
                acbOptionThird.text = listOfQuestions[currentQuestionPosition].third
                acbOptionFourth.text = listOfQuestions[currentQuestionPosition].fourth
            }
        } else {
            val action = OnExamFragmentDirections.actionOnExamFragmentToResultFragment(correctAnswers,10 - correctAnswers)
                findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}