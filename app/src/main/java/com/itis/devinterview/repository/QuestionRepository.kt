package com.itis.devinterview.repository

import com.itis.devinterview.model.Question

interface QuestionRepository {
    fun getQuestionById(id: Int): Question?
    fun getRandomQuestion(): Question?
    fun getAllQuestions(): List<Question>?
    fun addList(list: List<Question>)
    fun getQuestionListByLanguage(language: String): List<Question>?
    fun addQuestionList()
}