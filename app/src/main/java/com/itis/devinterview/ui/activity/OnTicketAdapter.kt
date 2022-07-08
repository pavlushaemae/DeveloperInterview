package com.itis.devinterview.ui.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.itis.devinterview.ui.fragment.*

class OnTicketAdapter(
    fragment: SecondaryOnTicketFragment
) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 10

    override fun createFragment(position: Int): Fragment {
        val fragment = OnTicketFragment()
        fragment.arguments = Bundle().apply {
            putInt(ARG_OBJECT_SECOND, position + 1)
        }
        return fragment
    }
}