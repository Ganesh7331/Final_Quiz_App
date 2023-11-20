package com.example.finalquizapp.ui.theme.questions


data class Question(
    var question: String,
    val options: List<String>,
    val correctAnswer: String
)

