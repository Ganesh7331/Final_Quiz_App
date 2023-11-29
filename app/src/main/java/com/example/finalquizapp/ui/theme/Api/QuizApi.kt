package com.example.finalquizapp.ui.theme.Api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QuizApi {

    @GET("/api.php")
    suspend fun getQuestion(
        @Query("amount") amount: Int,
        @Query("category") category: Int,
        @Query("difficulty") difficulty: String,
        @Query("type") type: String
    ): Response<QuizData>
}