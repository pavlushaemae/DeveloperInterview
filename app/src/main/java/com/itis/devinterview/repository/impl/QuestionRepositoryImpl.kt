package com.itis.devinterview.repository.impl

import android.content.SharedPreferences
import com.itis.devinterview.model.Question
import com.itis.devinterview.preferences.AccessToRepository
import com.itis.devinterview.preferences.AccessToRepository.getSP
import com.itis.devinterview.repository.QuestionRepository
import kotlin.random.Random

object QuestionRepositoryImpl : QuestionRepository {
    val questions = arrayListOf<Question>(
        Question(0, "Java", "a"),
        Question(1, "Java", "a"),
        Question(2, "Java", "a"),
        Question(3, "Java", "a"),
        Question(4, "Java", "a"),
        Question(5, "Java", "a"),
        Question(6, "Java", "a"),
        Question(7, "Java", "a"),
        Question(8, "Java", "a"),
        Question(9, "Java", "a"),
        Question(10, "Java", "a"),
        Question(11, "Java", "a"),
        Question(12, "Java", "a"),
        Question(13, "Java", "a"),
        Question(14, "Java", "a"),
        Question(15, "Java", "a"),
        Question(16, "Java", "a"),
        Question(17, "Java", "a"),
        Question(18, "Java", "a"),
        Question(19, "Java", "a"),
        Question(20, "Java", "a"),
        Question(21, "Java", "a"),
        Question(22, "Java", "a"),
        Question(23, "Java", "a"),
        Question(24, "Java", "a"),
        Question(25, "Java", "a"),
        Question(26, "Java", "a"),
        Question(27, "Java", "a"),
        Question(28, "Java", "a"),
        Question(29, "Java", "a"),
        Question(30, "Java", "a"),
        Question(31, "Java", "a"),
        Question(32, "Java", "a"),
        Question(33, "Java", "a"),
        Question(34, "Java", "a"),
        Question(35, "Java", "a"),
        Question(36, "Java", "a"),
        Question(37, "Java", "a"),
        Question(38, "Java", "a"),
        Question(39, "Java", "a"),
    )


    override fun getQuestionById(id: Int): Question? {
         var list = AccessToRepository.getListFromSP()
            return list?.get(id)
    }

    override fun getRandomQuestion(): Question? {
        var list = AccessToRepository.getListFromSP()
        var size = list?.size
        var rand = (0..size!!).random()
        return list?.get(rand)
    }

    override fun getAllQuestions(): List<Question>? {
        return AccessToRepository.getListFromSP()?.toList()
    }

    override fun addList(list: List<Question>){
        for (question in list){
            AccessToRepository.addQuestion(question)
        }
    }
}