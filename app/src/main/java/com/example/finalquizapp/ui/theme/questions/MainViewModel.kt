package com.example.finalquizapp.ui.theme.questions

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalquizapp.ui.theme.Api.Quiz
import com.example.finalquizapp.ui.theme.di.RetrofitInstance
import kotlinx.coroutines.launch

class MainViewModel(number:Int,difficulty:String) : ViewModel(){


    private val _questionsState = mutableStateOf(QuestionsState())
    val questionsState: State<QuestionsState> = _questionsState

    init {
        fetchQuestions(number, difficulty)
    }

    private fun fetchQuestions(number:Int,difficulty:String){
        var questions:List<Question> = emptyList()
        viewModelScope.launch {
            val response= RetrofitInstance.api.getQuestion(10,number, difficulty ,"multiple")
            if(response.isSuccessful){
                val abc=response.body()!!.results



                _questionsState.value=_questionsState.value.copy(
                    loading = false,
                    list = abc,
                    error = null
                )




            }
        }
    }

    data class QuestionsState(
        val loading:Boolean=true,
        val list: List<Quiz> = emptyList(),
        val error:String?=null
    )

}