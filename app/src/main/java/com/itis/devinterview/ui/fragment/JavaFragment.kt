package com.itis.devinterview.ui.fragment

import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.view.View
import androidx.fragment.app.Fragment
import com.itis.devinterview.R
import com.itis.devinterview.databinding.FragmentJavaBinding

class JavaFragment: Fragment(R.layout.fragment_java) {
    private var _binding: FragmentJavaBinding? = null
    private val binding get() = _binding!!
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentJavaBinding.bind(view)
        with(binding) {
            textView9.setOnClickListener {
                textView9.movementMethod = LinkMovementMethod.getInstance()
            }

        }

        with(binding) {
            textView10.setOnClickListener {
                textView10.movementMethod = LinkMovementMethod.getInstance()
            }

        }
        with(binding) {
            textView11.setOnClickListener {
                textView11.movementMethod = LinkMovementMethod.getInstance()
            }

        }
        with(binding) {
            textView12.setOnClickListener {
                textView12.movementMethod = LinkMovementMethod.getInstance()
            }

        }
        with(binding) {
            textView14.setOnClickListener {
                textView14.movementMethod = LinkMovementMethod.getInstance()
            }

        }
        with(binding) {
            textView16.setOnClickListener {
                textView16.movementMethod = LinkMovementMethod.getInstance()
            }

        }
        with(binding) {
            textView17.setOnClickListener {
                textView17.movementMethod = LinkMovementMethod.getInstance()
            }

        }
        with(binding) {
            textView18.setOnClickListener {
                textView18.movementMethod = LinkMovementMethod.getInstance()
            }

        }
        with(binding) {
            textView19.setOnClickListener {
                textView19.movementMethod = LinkMovementMethod.getInstance()
            }

        }
        with(binding) {
            textView25.setOnClickListener {
                textView25.movementMethod = LinkMovementMethod.getInstance()
            }

        }
        with(binding) {
            textView27.setOnClickListener {
                textView27.movementMethod = LinkMovementMethod.getInstance()
            }

        }
        with(binding) {
            textView28.setOnClickListener {
                textView28.movementMethod = LinkMovementMethod.getInstance()
            }

        }
        with(binding) {
            textView29.setOnClickListener {
                textView29.movementMethod = LinkMovementMethod.getInstance()
            }


        }


    }
}