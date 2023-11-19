package com.example.finalquizapp.ui.theme.Navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.initializer
import com.example.finalquizapp.ui.theme.questions.CircularProgressIndicator1
import com.example.finalquizapp.ui.theme.questions.MainViewModel
import com.example.finalquizapp.ui.theme.questions.MainViewModelFactory
import com.example.finalquizapp.ui.theme.questions.question_screen

@Composable
fun ScreenDecider(number:Int,difficulty:String) {
    val questionViewModel: MainViewModel = viewModel(factory = MainViewModelFactory {
        initializer {
            MainViewModel(number, difficulty)
        }
    })

    val viewstate by questionViewModel.questionsState

    Box(modifier = Modifier.fillMaxSize()){
        when{
            viewstate.loading ->{
                CircularProgressIndicator1()
            }
            else ->{
                question_screen(viewstate.list)
            }
        }
    }
}