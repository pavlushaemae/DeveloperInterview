package com.itis.devinterview.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.itis.devinterview.R
import com.itis.devinterview.databinding.FragmentSettingsBinding

class SettingsFragment: Fragment(R.layout.fragment_settings) {

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSettingsBinding.bind(view)

        with(binding) {
//            radioRussian.setOnClickListener {
//
//            }
//            radioEnglish.setOnClickListener {
//
//            }
//            radioLight.setOnClickListener {
//
//            }
//            radioDark.setOnClickListener {
//
//            }
//            tvResetStatistics.setOnClickListener {
//
//            }
            tvConfigureNotifications.setOnClickListener {
                findNavController().navigate(
                    R.id.action_settings_fragment_to_configure_notifications_fragment
                )
            }
            btnFeedback.setOnClickListener {
                findNavController().navigate(
                    R.id.action_settings_fragment_to_feedback_fragment
                )
            }
            tvUserAgreement.setOnClickListener {
                findNavController().navigate(
                    R.id.action_settings_fragment_to_user_agreement_fragment
                )
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}