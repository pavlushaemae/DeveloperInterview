package com.itis.devinterview.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.itis.devinterview.R
import com.itis.devinterview.databinding.FragmentSecondaryOnTicketBinding
import com.itis.devinterview.service.impl.QuestionServiceImpl
import com.itis.devinterview.ui.activity.OnTicketAdapter

class SecondaryOnTicketFragment : Fragment(R.layout.fragment_secondary_on_ticket) {
    private var _binding: FragmentSecondaryOnTicketBinding? = null
    private val binding get() = _binding!!
    private val questionServiceImpl = QuestionServiceImpl()
    private lateinit var adapter: OnTicketAdapter
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
//    private val tavNumbers: Array<Int> = arrayOf(
//
//    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSecondaryOnTicketBinding.bind(view)
        adapter = OnTicketAdapter(this)
        viewPager = binding.vpPager
        viewPager.adapter = adapter
        tabLayout = binding.tabLayout
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tabNames[position]
        }.attach()

        val args by navArgs<SecondaryOnTicketFragmentArgs>()
        val idOfTicket: Int = args.idArg
        val language = args.languageArg

        // Здесь вопросы, 10 вопросов, они уже подобраны. Нужно просто из этого листа перепихать их в вопросы билета на экране
        var listOfQuestions = questionServiceImpl.getTenQuestions(idOfTicket, language)

    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}