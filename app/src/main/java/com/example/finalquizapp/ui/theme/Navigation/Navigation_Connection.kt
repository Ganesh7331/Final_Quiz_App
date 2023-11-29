package com.example.finalquizapp.ui.theme.Navigation

import android.annotation.SuppressLint
import androidx.compose.animation.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.finalquizapp.R
import com.example.finalquizapp.ui.theme.Category.CategoryListScreen
import com.example.finalquizapp.ui.theme.History.HistoryViewModel
import com.example.finalquizapp.ui.theme.difficulty.DifficultyCardView
import com.example.finalquizapp.ui.theme.Navigation.ScreenDecider
import kotlinx.coroutines.delay

//@SuppressLint("CoroutineCreationDuringComposition")
//@Composable
//fun Navigation_Connection() {
//
//    var number by remember { mutableIntStateOf(10) }
//    var difficulty by remember { mutableStateOf("easy") }
//    var showCategoryScreen by remember { mutableStateOf(false) }
//    var showDifficultScreen by remember { mutableStateOf(false) }
//    var showProgressBar by remember{ mutableStateOf(false) }
//
//    var currentScreen by remember { mutableStateOf("splash") }
//
//    if(!showCategoryScreen && currentScreen=="splash"){
//        SplashScreen { showCategoryScreen=true;currentScreen="none" }
//    }
//
//
//
//
//
//    else if (showCategoryScreen) {
//        CategoryListScreen(onButtonClick = {
//                value ->
//            number = value
//            showCategoryScreen = false; showDifficultScreen = true })
//    }
//
//
//
//    else if (showDifficultScreen) {
//        DifficultyCardView(onButtonClick = {
//                value ->
//            difficulty = value
//            showProgressBar = true; showDifficultScreen = false })
//    }
//
//    else if(showProgressBar){
//        ScreenDecider(number,difficulty)
//    }
//
//}

@Composable
fun SplashScreen(navController: NavController) {



    LaunchedEffect(key1 = true) {
        delay(1000L)
        navController.navigate("login_screen") {
            // This will remove the splash screen from the back stack
            popUpTo("splash_screen") { inclusive = true }
        }
    }

    val image: Painter = painterResource(id = R.drawable.app_icon)

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Image(
            painter = image,
            contentDescription = "Splash Screen Image",
            modifier = Modifier
                .size(150.dp)
                .align(Alignment.Center)
        )
    }


}