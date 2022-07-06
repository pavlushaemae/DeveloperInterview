package com.itis.devinterview.service

import com.itis.devinterview.model.Question

interface QuestionService {
    fun getQuestionById(id: Int): Question?
    fun getRandomQuestion(): Question?
    fun getAllQuestions(): List<Question>?
    fun addList(list: List<Question>)
}