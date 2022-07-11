package com.itis.devinterview.ui.fragment

import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.view.View
import androidx.fragment.app.Fragment
import com.itis.devinterview.R
import com.itis.devinterview.databinding.FragmentFeedbackBinding

class FeedbackFragment : Fragment(R.layout.fragment_feedback) {
    private var _binding: FragmentFeedbackBinding? = null
    private val binding get() = _binding!!
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentFeedbackBinding.bind(view)
        with(binding) {
            tvLinkDinara.setOnClickListener {
                tvLinkDinara.movementMethod = LinkMovementMethod.getInstance()
            }
            tvLinkAndrew.setOnClickListener {
                tvLinkAndrew.movementMethod = LinkMovementMethod.getInstance()
            }
            tvLinkDanila.setOnClickListener {
                tvLinkDanila.movementMethod = LinkMovementMethod.getInstance()
            }
            tvLinkPavel.setOnClickListener {
                tvLinkPavel.movementMethod = LinkMovementMethod.getInstance()
            }
            tvLinkAlina.setOnClickListener {
                tvLinkAlina.movementMethod = LinkMovementMethod.getInstance()
            }
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}