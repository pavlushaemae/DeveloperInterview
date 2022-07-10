package com.itis.devinterview.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.itis.devinterview.R
import com.itis.devinterview.databinding.FragmentProfileBinding

class ProfileFragment : Fragment(R.layout.fragment_profile){

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentProfileBinding.bind(view)
        with(binding){
            button2.setOnClickListener{
                findNavController().navigate(R.id.action_profileFragment_to_settings_fragment)
            }
        }
    }
}