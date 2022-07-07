package com.itis.devinterview.ui.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.itis.devinterview.R
import com.itis.devinterview.databinding.FragmentSecondaryExamBinding

class SecondaryExamFragment : Fragment(R.layout.fragment_secondary_exam) {

    private var _binding: FragmentSecondaryExamBinding? = null
    private val binding get() = _binding!!

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

    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }


}