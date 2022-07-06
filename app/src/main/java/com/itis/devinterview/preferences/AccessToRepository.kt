package com.itis.devinterview.preferences

import android.annotation.SuppressLint
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.itis.devinterview.model.Question

object AccessToRepository {
    var newQuestionId: Int = 0
    private var sharedPreferences: SharedPreferences? = null
    private const val SHARED_PREFERENCES_KEY = "key"
    fun getSP(sharedPreferences: SharedPreferences) {
        AccessToRepository.sharedPreferences = sharedPreferences
        var list = getListFromSP()
        list?.map { it.id = newQuestionId++ }
        saveListToSP(list)
    }
    fun addQuestion(question: Question): Boolean {
        val list = getListFromSP() ?: mutableListOf()
        return if (list.contains(question)) {
            false
        } else {
            list.add(question)
            saveListToSP(list)
            true
        }
    }
    fun deleteQuestion(question: Question) {
        val list = getListFromSP()
        list?.remove(question)
        saveListToSP(list)
    }

//    fun moveMedia(question: Question?, target: MediaStatusEnum) {
//        val list = getListFromSP()
//        list?.map { if (it == question) it.status = target }
//        saveListToSP(list)
//    }
//    fun getAllFinishedMedia() = getListFromSP()?.filter { it.status == MediaStatusEnum.FINISHED }
//    fun getAllCurrentMedia() = getListFromSP()?.filter { it.status == MediaStatusEnum.CURRENT }
//    fun getAllNewMedia() = getListFromSP()?.filter { it.status == MediaStatusEnum.NEW }

    fun getListFromSP(): MutableList<Question>? {
        val gson = Gson()
        val json = sharedPreferences?.getString(SHARED_PREFERENCES_KEY, null)
        val type = object : TypeToken<MutableList<Question>>() {}.type
        return gson.fromJson(json, type)
    }

    @SuppressLint("CommitPrefEdits")
    private fun saveListToSP(list: MutableList<Question>?) {
        sharedPreferences?.edit()?.apply {
            putString(SHARED_PREFERENCES_KEY, Gson().toJson(list))
            apply()
        }
    }
}