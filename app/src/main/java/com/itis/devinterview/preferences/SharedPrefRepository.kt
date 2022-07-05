package com.itis.devinterview.preferences

import android.content.Context
import android.content.SharedPreferences
import com.itis.devinterview.ui.fragment.TestingFragment

const val STORAGE_NAME = "StorageName"

class SharedPrefRepository {
    private var questions: SharedPreferences? = null
    private var editor: SharedPreferences.Editor? = null
    private var context: Context? = null
    fun init(cntxt: Context?) {
        context = cntxt
    }

    private fun init() {
        questions = context?.getSharedPreferences(STORAGE_NAME, Context.MODE_PRIVATE)
        editor = questions?.edit()
    }

    fun addProperty(name: String?, value: String?) {
        if (questions == null) {
            init()
        }
        editor?.putString(name, value)
        editor?.commit()
    }

    fun getProperty(name: String?): String? {
        if (questions == null) {
            init()
        }
        return questions?.getString(name, null)
    }

}