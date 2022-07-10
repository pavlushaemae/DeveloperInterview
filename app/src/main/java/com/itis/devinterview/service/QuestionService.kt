package com.itis.devinterview.service

import com.itis.devinterview.model.Question

interface QuestionService {
    fun getQuestionById(id: Int): Question?
    fun getRandomQuestion(): Question?
    fun getAllQuestions(): List<Question>?
    fun addList(list: List<Question>)
    fun getQuestionListByLanguage(language: String): List<Question>?
    fun addQuestionList()
    fun getTenQuestions(id: Int, language: String): List<Question>
    fun getTenRandomQuestions(language: String): List<Question>
    fun addOneTicket(language: String)
    fun getCountOfTestedTickets(language: String): Int?
    fun addFirstLaunch()
    fun getFirstLaunch(): Boolean
}