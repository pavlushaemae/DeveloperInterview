package com.itis.devinterview.ui.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.itis.devinterview.R
import com.itis.devinterview.databinding.FragmentEducationBinding
import com.itis.devinterview.ui.rv.LanguageAdapter
import com.itis.devinterview.ui.rv.LanguageRepository

private const val KEY_LAN = "ID"
class EducationFragment : Fragment(R.layout.fragment_education) {

    private var _binding: FragmentEducationBinding? = null
    private var languageAdapter: LanguageAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentEducationBinding.bind(view)
        initAdapter()
    }

    private fun initAdapter() {
        languageAdapter = LanguageAdapter(
            LanguageRepository.languages
        ){
            navigate(it.url)
        }
        _binding?.let{
            it.recyclerView.adapter = languageAdapter
        }



    }

    private fun navigate(url: String) {
        val uri: Uri = Uri.parse(url)
        val intent: Intent = Intent(
            Intent.ACTION_VIEW,
            uri
        )
        startActivity(intent)


    }




}