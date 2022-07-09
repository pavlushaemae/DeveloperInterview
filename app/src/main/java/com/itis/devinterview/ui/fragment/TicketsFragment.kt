package com.itis.devinterview.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.itis.devinterview.R
import com.itis.devinterview.databinding.FragmentTicketsBinding
import com.itis.devinterview.recycler.tickets.TicketsAdapter
import com.itis.devinterview.recycler.tickets.TicketsRepository

class TicketsFragment : Fragment(R.layout.fragment_tickets) {

    private var _binding: FragmentTicketsBinding? = null
    private val binding get() = _binding!!
    private var adapter: TicketsAdapter? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentTicketsBinding.bind(view)
        initAdapter()
    }

    private fun initAdapter() {
        val args by navArgs<TicketsFragmentArgs>()
        val language = args.languageArg
        adapter = TicketsAdapter(
            TicketsRepository.tickets,
        ) {
            val action = TicketsFragmentDirections.actionTicketsFragmentToOnTicketFragment(
                it.id,
                language
            )
            binding.root.findNavController().navigate(action)
        }
        binding.rvPlanet.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}