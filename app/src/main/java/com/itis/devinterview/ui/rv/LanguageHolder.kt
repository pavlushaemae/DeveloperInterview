package com.itis.devinterview.ui.rv

import androidx.recyclerview.widget.RecyclerView
import com.itis.devinterview.databinding.ItemBottomOfEducationBinding

class LanguageHolder (
    private val binding: ItemBottomOfEducationBinding,
    private val onItemClick: (Language) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {


    fun onBind(item: Language) {
        with(binding) {
            tvName.text = item.name
            ivImage.setImageResource(item.image)
            root.setOnClickListener {
                onItemClick(item)
            }
        }
    }
}