package com.example.finalquizapp.ui.theme.Navigation

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.finalquizapp.ui.theme.Category.CategoryListScreen
import com.example.finalquizapp.ui.theme.difficulty.DifficultyCardView
import com.example.finalquizapp.ui.theme.Navigation.ScreenDecider

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun Navigation_Connection() {

    var number by remember { mutableIntStateOf(10) }
    var difficulty by remember { mutableStateOf("easy") }
    var showCategoryScreen by remember { mutableStateOf(true) }
    var showDifficultScreen by remember { mutableStateOf(false) }
    var showProgressBar by remember{ mutableStateOf(false) }



    if (showCategoryScreen) {
        CategoryListScreen(onButtonClick = {
                value ->
            number = value
            showCategoryScreen = false; showDifficultScreen = true })
    }



    else if (showDifficultScreen) {
        DifficultyCardView(onButtonClick = {
                value ->
            difficulty = value
            showProgressBar = true; showDifficultScreen = false })
    }
    
    else if(showProgressBar){
        ScreenDecider(number,difficulty)
    }

}