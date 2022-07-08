package com.itis.devinterview.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.itis.devinterview.R

const val ARG_OBJECT_SECOND = "object"
class OnTicketFragment: Fragment(R.layout.fragment_on_ticket) {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_on_ticket, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments?.takeIf { it.containsKey(ARG_OBJECT_SECOND) }?.apply {
            val textQuestion: TextView = view.findViewById(R.id.tv_question)
            textQuestion.text = getInt(ARG_OBJECT_SECOND).toString()
        }
    }
}