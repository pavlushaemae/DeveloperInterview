package com.itis.devinterview.ui.rv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.itis.devinterview.databinding.ItemBottomOfEducationBinding

class LanguageAdapter(
    private var list: List<Language>,
    private val onItemClick: (Language) -> Unit,
) : RecyclerView.Adapter<LanguageHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LanguageHolder = LanguageHolder(
        binding = ItemBottomOfEducationBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ),
        onItemClick = onItemClick
    )

    override fun onBindViewHolder(
        holder: LanguageHolder,
        position: Int
    ) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

}