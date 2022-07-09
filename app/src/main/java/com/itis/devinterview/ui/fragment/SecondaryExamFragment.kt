package com.itis.devinterview.ui.fragment

import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.navArgs
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.itis.devinterview.R
import com.itis.devinterview.databinding.FragmentSecondaryExamBinding
import com.itis.devinterview.service.impl.QuestionServiceImpl
import com.itis.devinterview.ui.activity.ExamAdapter

class SecondaryExamFragment : Fragment(R.layout.fragment_secondary_exam) {

    private var _binding: FragmentSecondaryExamBinding? = null
    private val binding get() = _binding!!
    private val questionServiceImpl = QuestionServiceImpl()
    private lateinit var adapter: ExamAdapter
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout
    private val tabNames: Array<String> = arrayOf(
        "1",
        "2",
        "3",
        "4",
        "5",
        "6",
        "7",
        "8",
        "9",
        "10"
    )

    private val tavNumbers: Array<Int> = arrayOf(

    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSecondaryExamBinding.bind(view)

        adapter = ExamAdapter(this)
        viewPager = binding.vpPager
        viewPager.adapter = adapter

        tabLayout = binding.tabLayout
        TabLayoutMediator(tabLayout, viewPager) {tab, position ->
            tab.text = tabNames[position]
        }.attach()
        val args by navArgs<SecondaryExamFragmentArgs>()
        val language = args.languageArg

        // Здесь вопросы, 10 вопросов, они уже подобраны.
        // Нужно просто из этого листа перепихать их в вопросы билета на экране
        val listOfQuestions = questionServiceImpl.getTenRandomQuestions(language)
        val textQuestion = serviceImplForExam.getRandomQuestion()

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
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }


}