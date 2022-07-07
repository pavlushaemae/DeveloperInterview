package com.itis.devinterview.ui.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.itis.devinterview.ui.fragment.ARG_OBJECT
import com.itis.devinterview.ui.fragment.ExamFragment
import com.itis.devinterview.ui.fragment.SecondaryExamFragment

class ExamAdapter(fragment: SecondaryExamFragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 10

    override fun createFragment(position: Int): Fragment {
        val fragment = ExamFragment()
        fragment.arguments = Bundle().apply {
            putInt(ARG_OBJECT, position + 1)
        }
        return fragment
        // либо ExamAdapter(fragment: ExamFragment)
    }
}