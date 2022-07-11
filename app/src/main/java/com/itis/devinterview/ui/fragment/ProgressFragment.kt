package com.itis.devinterview.ui.fragment

import androidx.fragment.app.Fragment
import com.itis.devinterview.R
import com.itis.devinterview.model.Question
import com.itis.devinterview.service.QuestionService

class ProgressFragment : Fragment(R.layout.fragment_progress), QuestionService {
    override fun getQuestionById(id: Int): Question? {
        TODO("Not yet implemented")
    }

    override fun getRandomQuestion(): Question? {
        TODO("Not yet implemented")
    }

    override fun getAllQuestions(): List<Question>? {
        TODO("Not yet implemented")
    }

    override fun addList(list: List<Question>) {
        TODO("Not yet implemented")
    }

    override fun getQuestionListByLanguage(language: String): List<Question>? {
        TODO("Not yet implemented")
    }

    override fun addQuestionList() {
        TODO("Not yet implemented")
    }

    override fun getTenQuestions(id: Int, language: String): List<Question> {
        TODO("Not yet implemented")
    }

    override fun getTenRandomQuestions(language: String): List<Question> {
        TODO("Not yet implemented")
    }
}