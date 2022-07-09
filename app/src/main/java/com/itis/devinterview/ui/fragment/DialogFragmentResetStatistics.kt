package com.itis.devinterview.ui.fragment

import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.itis.devinterview.R
import java.io.File

class DialogFragmentResetStatistics : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it, R.style.YDialog)
            builder
                .setMessage("Прогресс обучения будет сброшен\nВы уверены?")
                .setCancelable(true)
                .setPositiveButton("Да") { dialog, id ->
                    File(requireContext().cacheDir.path).deleteRecursively()
                    Toast.makeText(
                        activity, "Прогресс сброшен",
                        Toast.LENGTH_LONG
                    ).show()
                }
                .setNegativeButton(
                    "Нет"
                ) { dialog, id ->
                    dialog.cancel()
                }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}