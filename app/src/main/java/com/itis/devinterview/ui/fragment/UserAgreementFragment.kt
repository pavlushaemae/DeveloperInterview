package com.itis.devinterview.ui.fragment

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.itis.devinterview.R
import org.w3c.dom.Text

class UserAgreementFragment: Fragment(R.layout.fragment_user_agreement) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var text: TextView = view.findViewById(R.id.textview)
        text.text = "jjj"
    }
}