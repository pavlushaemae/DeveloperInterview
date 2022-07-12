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
import com.itis.devinterview.R
import com.itis.devinterview.databinding.FragmentOnExamBinding
import com.itis.devinterview.model.Question
import com.itis.devinterview.preferences.AccessToRepository
import com.itis.devinterview.service.impl.QuestionServiceImpl

class OnTicketFragment : Fragment(R.layout.fragment_on_ticket) {
    private var _binding: FragmentOnExamBinding? = null
    private val binding get() = _binding!!
    private val questionServiceImpl = QuestionServiceImpl()
    private lateinit var questionTimer: Chronometer
    private var currentQuestionPosition = 0
    private var selectedOptionByUser = ""
    private lateinit var listOfQuestions: List<Question>
    private var correctAnswers = 0
    private lateinit var lang: String
    private var idOfTick: Int = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentOnExamBinding.bind(view)
        val args by navArgs<OnTicketFragmentArgs>()
        val idOfTicket: Int = args.idArg
        val language = args.languageArg
        lang = language
        idOfTick = idOfTicket
        listOfQuestions = questionServiceImpl.getTenQuestions(idOfTicket, language)
        startTimer(600)
        with(binding) {
            tvQuestions.text = "${currentQuestionPosition + 1}/${listOfQuestions.size}"
            tvQuestion.text = listOfQuestions[0].question
            acbOptionFirst.text = listOfQuestions[0].first
            acbOptionSecond.text = listOfQuestions[0].second
            acbOptionThird.text = listOfQuestions[0].third
            acbOptionFourth.text = listOfQuestions[0].fourth
            acbOptionFirst.setOnClickListener {
                if (selectedOptionByUser.isEmpty()) {
                    selectedOptionByUser = acbOptionFirst.text.toString()
                    if (selectedOptionByUser == listOfQuestions[currentQuestionPosition].correct) {
                        correctAnswers++
                    }
                    acbOptionFirst.setBackgroundResource(R.drawable.round_back_red_10)
                    acbOptionFirst.setTextColor(Color.WHITE)
                    revealAnswer()
                }
            }
            acbOptionSecond.setOnClickListener {
                if (selectedOptionByUser.isEmpty()) {
                    selectedOptionByUser = acbOptionSecond.text.toString()
                    if (selectedOptionByUser == listOfQuestions[currentQuestionPosition].correct) {
                        correctAnswers++
                    }
                    acbOptionSecond.setBackgroundResource(R.drawable.round_back_red_10)
                    acbOptionSecond.setTextColor(Color.WHITE)
                    revealAnswer()
                }
            }
            acbOptionThird.setOnClickListener {
                if (selectedOptionByUser.isEmpty()) {
                    selectedOptionByUser = acbOptionThird.text.toString()
                    if (selectedOptionByUser == listOfQuestions[currentQuestionPosition].correct) {
                        correctAnswers++
                    }
                    acbOptionThird.setBackgroundResource(R.drawable.round_back_red_10)
                    acbOptionThird.setTextColor(Color.WHITE)
                    revealAnswer()
                }
            }
            acbOptionFourth.setOnClickListener {
                if (selectedOptionByUser.isEmpty()) {
                    selectedOptionByUser = acbOptionFourth.text.toString()
                    if (selectedOptionByUser == listOfQuestions[currentQuestionPosition].correct) {
                        correctAnswers++
                    }
                    acbOptionFourth.setBackgroundResource(R.drawable.round_back_red_10)
                    acbOptionFourth.setTextColor(Color.WHITE)
                    revealAnswer()
                }
            }
            btnNext.setOnClickListener {
                if (selectedOptionByUser.isEmpty()) {
                    Toast.makeText(context, "Выберите правильный ответ", Toast.LENGTH_SHORT).show()
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

                Toast.makeText(context, "Время вышло", Toast.LENGTH_SHORT).show()
                val action = OnTicketFragmentDirections.actionOnTicketFragmentToResultFragment(
                    correctAnswers,
                    10 - correctAnswers,
                    lang,
                    idOfTick
                )
                findNavController().navigate(action)
            }
        }
    }

    private fun revealAnswer() {
        val getAnswer = listOfQuestions[currentQuestionPosition].correct
        if (binding.acbOptionFirst.text.toString() == getAnswer) {
            binding.acbOptionFirst.setBackgroundResource(R.drawable.round_back_green_10)
            binding.acbOptionFirst.setTextColor(Color.WHITE)
        } else if (binding.acbOptionSecond.text.toString() == getAnswer) {
            binding.acbOptionSecond.setBackgroundResource(R.drawable.round_back_green_10)
            binding.acbOptionSecond.setTextColor(Color.WHITE)
        } else if (binding.acbOptionThird.text.toString() == getAnswer) {
            binding.acbOptionThird.setBackgroundResource(R.drawable.round_back_green_10)
            binding.acbOptionThird.setTextColor(Color.WHITE)
        } else if (binding.acbOptionFourth.text.toString() == getAnswer) {
            binding.acbOptionFourth.setBackgroundResource(R.drawable.round_back_green_10)
            binding.acbOptionFourth.setTextColor(Color.WHITE)
        }
    }

    private fun changeNextQuestion() {
        currentQuestionPosition++
        if ((currentQuestionPosition + 1) == listOfQuestions.size) {
            binding.btnNext.text = "Готово"
        }
        if (currentQuestionPosition < listOfQuestions.size) {
            selectedOptionByUser = ""
            with(binding) {
                if (AccessToRepository.isNightThemeEnabled() == false) {
                    acbOptionFirst.setBackgroundResource(R.drawable.round_back_white_stroke)
                    acbOptionSecond.setBackgroundResource(R.drawable.round_back_white_stroke)
                    acbOptionThird.setBackgroundResource(R.drawable.round_back_white_stroke)
                    acbOptionFourth.setBackgroundResource(R.drawable.round_back_white_stroke)
                    acbOptionFirst.setTextColor(Color.parseColor("#FF000000"))
                    acbOptionSecond.setTextColor(Color.parseColor("#FF000000"))
                    acbOptionThird.setTextColor(Color.parseColor("#FF000000"))
                    acbOptionFourth.setTextColor(Color.parseColor("#FF000000"))
                } else {
                    acbOptionFirst.setBackgroundResource(R.drawable.round_back_black_stroke)
                    acbOptionSecond.setBackgroundResource(R.drawable.round_back_black_stroke)
                    acbOptionThird.setBackgroundResource(R.drawable.round_back_black_stroke)
                    acbOptionFourth.setBackgroundResource(R.drawable.round_back_black_stroke)
                    acbOptionFirst.setTextColor(Color.parseColor("#FFFFFF"))
                    acbOptionSecond.setTextColor(Color.parseColor("#FFFFFF"))
                    acbOptionThird.setTextColor(Color.parseColor("#FFFFFF"))
                    acbOptionFourth.setTextColor(Color.parseColor("#FFFFFF"))
                }
                tvQuestions.text = "${currentQuestionPosition + 1}/${listOfQuestions.size}"
                tvQuestion.text = listOfQuestions[currentQuestionPosition].question
                acbOptionFirst.text = listOfQuestions[currentQuestionPosition].first
                acbOptionSecond.text = listOfQuestions[currentQuestionPosition].second
                acbOptionThird.text = listOfQuestions[currentQuestionPosition].third
                acbOptionFourth.text = listOfQuestions[currentQuestionPosition].fourth
            }
        } else {
            val action = OnTicketFragmentDirections.actionOnTicketFragmentToResultFragment(
                correctAnswers,
                10 - correctAnswers,
                lang,
                idOfTick
            )
            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }


}