package com.itis.devinterview.recycler.tickets

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.itis.devinterview.databinding.ItemTicketBinding

class TicketsAdapter(
    private var list: List<Ticket>,
    private val onItemClick: (Ticket) -> Unit
) :
    RecyclerView.Adapter<TicketsHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TicketsHolder =
        TicketsHolder(
            binding = ItemTicketBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            onItemClick = onItemClick
        )

    override fun onBindViewHolder(
        holder: TicketsHolder,
        position: Int
    ) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size
}