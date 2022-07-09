package com.itis.devinterview.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.itis.devinterview.R

const val ARG_OBJECT = "object"

open class ExamFragment : Fragment(R.layout.fragment_exam) {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_exam, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments?.takeIf { it.containsKey(ARG_OBJECT) }?.apply {
            val textQuestion: TextView = view.findViewById(R.id.tv_question)
            textQuestion.text = getInt(ARG_OBJECT).toString()
        }

    }
}