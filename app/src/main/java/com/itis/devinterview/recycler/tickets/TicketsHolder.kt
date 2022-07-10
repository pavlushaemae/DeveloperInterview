package com.itis.devinterview.recycler.tickets

import androidx.recyclerview.widget.RecyclerView
import com.itis.devinterview.databinding.ItemTicketBinding

class TicketsHolder(
    private val binding:ItemTicketBinding,
    private val onItemClick: (Ticket) -> Unit
): RecyclerView.ViewHolder(binding.root) {
    fun onBind(ticket: Ticket) {
        with(binding) {
            tvName.text = "${ticket.id} ${ticket.text}"
            root.setOnClickListener {
                onItemClick(ticket)
            }
        }
    }
}