package com.itis.devinterview.ui.fragment

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.itis.devinterview.databinding.FragmentSettingsBinding
import com.itis.devinterview.preferences.AccessToRepository


class SettingsFragment : Fragment(com.itis.devinterview.R.layout.fragment_settings) {

    private lateinit var sharedPreferences: SharedPreferences
    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentSettingsBinding.bind(view)
        with(binding) {
            sharedPreferences = requireActivity().getSharedPreferences("save", MODE_PRIVATE)
            switchThemes.isChecked = sharedPreferences.getBoolean("value", true)
            switchThemes.setOnCheckedChangeListener { _, checkedId ->
                when (checkedId) {
                    true -> {
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                        AccessToRepository.addNightThemeEnabled()
                        val editor: SharedPreferences.Editor =
                            requireActivity().getSharedPreferences("save", MODE_PRIVATE).edit()
                        editor.putBoolean("value", true)
                        editor.apply()
                        switchThemes.isChecked = true
                    }
                    false -> {
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                        AccessToRepository.addLightThemeEnabled()
                        val editor: SharedPreferences.Editor =
                            requireActivity().getSharedPreferences("save", MODE_PRIVATE).edit()
                        editor.putBoolean("value", false)
                        editor.apply()
                        switchThemes.isChecked = false
                        
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