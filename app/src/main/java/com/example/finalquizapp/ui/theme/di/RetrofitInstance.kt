package com.example.finalquizapp.ui.theme.di

import com.example.finalquizapp.ui.theme.Api.QuizApi
import com.example.finalquizapp.ui.theme.QuizApp
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitInstance {

    val api: QuizApi by lazy{
        Retrofit.Builder()
            .baseUrl("https://opentdb.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(QuizApi::class.java)
    }
}