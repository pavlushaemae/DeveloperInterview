package com.itis.devinterview.service.impl

import com.itis.devinterview.model.Question
import com.itis.devinterview.repository.QuestionRepository
import com.itis.devinterview.repository.impl.QuestionRepositoryImpl
import com.itis.devinterview.service.QuestionService

class QuestionServiceImpl: QuestionService {

    private val repository: QuestionRepository = QuestionRepositoryImpl()

    override fun getQuestionById(id: Int): Question? {
        return repository.getQuestionById(id)
    }

    override fun getRandomQuestion(): Question? {
        return repository.getRandomQuestion()
    }

    override fun getAllQuestions(): List<Question>? {
        return repository.getAllQuestions()
    }

    override fun addList(list: List<Question>) {
        repository.addList(list)
    }

    override fun getQuestionListByLanguage(language: String): List<Question>? {
        return repository.getQuestionListByLanguage(language)
    }

    override fun addQuestionList() {
        repository.addQuestionList()
    }
}