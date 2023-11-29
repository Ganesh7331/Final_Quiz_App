package com.example.finalquizapp.ui.theme.Api


data class Quiz(
    val category: String,
    val type: String,
    val difficulty: String,
    val question: String,
    val correct_answer: String,
    val incorrect_answers: Array<String>
)


data class QuizData(
    val response_code: Int,
    val results: List<Quiz>
)

