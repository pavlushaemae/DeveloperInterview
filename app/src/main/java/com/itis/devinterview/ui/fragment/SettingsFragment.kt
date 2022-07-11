package com.itis.devinterview.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.itis.devinterview.databinding.FragmentSettingsBinding
import com.itis.devinterview.preferences.AccessToRepository

class SettingsFragment : Fragment(com.itis.devinterview.R.layout.fragment_settings) {

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSettingsBinding.bind(view)
        with(binding) {
            switchThemes.setOnCheckedChangeListener { _, checkedId ->
                when (checkedId) {
                    true -> {
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                        AccessToRepository.addNightThemeEnabled()
                    }
                    false -> {
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                        AccessToRepository.addLightThemeEnabled()
                    }
                }
            }
            tvResetStatistics.setOnClickListener {
                val myDialogFragment = DialogFragmentResetStatistics()
                val manager = this@SettingsFragment.parentFragmentManager
                myDialogFragment.show(manager, "myDialog")
            }
            tvConfigureNotifications.setOnClickListener {
                findNavController().navigate(
                    com.itis.devinterview.R.id.action_settings_fragment_to_configure_notifications_fragment
                )
            }
            tvFeedback.setOnClickListener {
                findNavController().navigate(
                    com.itis.devinterview.R.id.action_settings_fragment_to_feedback_fragment
                )
            }
            tvUserAgreement.setOnClickListener {
                findNavController().navigate(
                    com.itis.devinterview.R.id.action_settings_fragment_to_user_agreement_fragment
                )
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}