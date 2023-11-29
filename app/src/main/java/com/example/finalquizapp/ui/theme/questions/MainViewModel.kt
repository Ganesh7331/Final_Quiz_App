package com.example.finalquizapp.ui.theme.questions

import android.content.Context
import android.util.Log
import android.view.View
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import androidx.room.Room
import com.example.finalquizapp.ui.theme.Api.Quiz
import com.example.finalquizapp.ui.theme.Database.HistoryDatabase
import com.example.finalquizapp.ui.theme.Database.HistoryItem
import com.example.finalquizapp.ui.theme.History.HistoryViewModel
import com.example.finalquizapp.ui.theme.SharedState
import com.example.finalquizapp.ui.theme.di.RetrofitInstance
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flatMapConcat


import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch



class MainViewModel(number: Int, difficulty: String,context: Context) : ViewModel() {


    private val _questionsState = mutableStateOf(QuestionsState())
    val questionsState: State<QuestionsState> = _questionsState







    init {
        fetchQuestions(number, difficulty)
//        getData(context)
    }








//




    private fun fetchQuestions(number: Int, difficulty: String) {

        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getQuestion(10, number, difficulty, "multiple")
                if (response.isSuccessful) {
                    val abc = response.body()!!.results
                    Log.e("HiGANESH", number.toString())
                    Log.e("HiGANESH", difficulty)



                    _questionsState.value = _questionsState.value.copy(
                        loading = false,
                        list = abc,
                        error = null
                    )

                    SharedState.updatehistorystate(HistoryViewModel.HistoryState(number = number,difficulty=difficulty))

//                    SharedState.historyState.value=SharedState.historyState.value.copy(
//                        number = number,
//                        difficulty=difficulty
//                    )



                }
            } catch (e: Exception) {
                println(e)
            }

        }
    }

    data class QuestionsState(
        val loading: Boolean = true,
        val list: List<Quiz> = emptyList(),
        val error: String? = null
    )






}