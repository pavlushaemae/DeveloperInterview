package com.itis.devinterview.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.itis.devinterview.R
import com.itis.devinterview.databinding.FragmentTicketsBinding
import com.itis.devinterview.service.impl.QuestionServiceImpl

class TicketsFragment : Fragment(R.layout.fragment_tickets) {

    private var _binding: FragmentTicketsBinding? = null
    private val binding get() = _binding!!
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentTicketsBinding.bind(view)
        val serviceImpl: QuestionServiceImpl = QuestionServiceImpl()
        val q = serviceImpl.getRandomQuestion()
        with(binding) {
            tvTicketFirst.text = q?.question
            tvTicketSecond.text = q?.first
            tvTicketThird.text = q?.second
            tvTicketFourth.text = q?.third
            tvTicketFifth.text = q?.fourth
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}