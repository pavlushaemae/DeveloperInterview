package com.itis.devinterview.ui.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.itis.devinterview.R
import com.itis.devinterview.databinding.FragmentSecondaryExamBinding

class SecondaryExamFragment : Fragment(R.layout.fragment_secondary_exam) {

    private lateinit var adapter: ExamAdapter
    private lateinit var viewPager: ViewPager2

    private var _binding: FragmentSecondaryExamBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSecondaryExamBinding.bind(view)

        adapter = ExamAdapter(this)
        viewPager = binding.vpPager
        viewPager.adapter = adapter

    }


    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }


}