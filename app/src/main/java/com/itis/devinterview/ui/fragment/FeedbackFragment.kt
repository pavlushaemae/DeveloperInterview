package com.itis.devinterview.ui.fragment

import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.view.View
import androidx.fragment.app.Fragment
import com.itis.devinterview.R
import com.itis.devinterview.databinding.FragmentFeedbackBinding

class FeedbackFragment: Fragment(R.layout.fragment_feedback) {
    private var _binding: FragmentFeedbackBinding? = null
    private val binding get() = _binding!!
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentFeedbackBinding.bind(view)
        with(binding){
            tvLinkOne.setOnClickListener(){
                tvLinkOne.movementMethod = LinkMovementMethod.getInstance()
            }
            tvLinkTwo.setOnClickListener(){
                tvLinkTwo.movementMethod = LinkMovementMethod.getInstance()
            }
            tvLinkThree.setOnClickListener(){
                tvLinkThree.movementMethod = LinkMovementMethod.getInstance()
            }
            tvLinkFour.setOnClickListener(){
                tvLinkFour.movementMethod = LinkMovementMethod.getInstance()
            }
            tvLinkFive.setOnClickListener(){
                tvLinkFive.movementMethod = LinkMovementMethod.getInstance()
            }
        }
    }
}