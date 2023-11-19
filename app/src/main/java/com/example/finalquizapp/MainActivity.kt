package com.example.finalquizapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.example.finalquizapp.ui.theme.Api.QuizApi
import com.example.finalquizapp.ui.theme.Category.Category
import com.example.finalquizapp.ui.theme.Category.CategoryListScreen
import com.example.finalquizapp.ui.theme.Category.ImageCard
import com.example.finalquizapp.ui.theme.FinalQuizAppTheme
import com.example.finalquizapp.ui.theme.Navigation_Connection

import com.example.finalquizapp.ui.theme.di.RetrofitInstance
import com.example.finalquizapp.ui.theme.difficulty.DifficultyCardView
import com.example.finalquizapp.ui.theme.questions.CircularProgressIndicator1
import com.example.finalquizapp.ui.theme.questions.FinalScreen
import com.example.finalquizapp.ui.theme.questions.Question

import com.example.finalquizapp.ui.theme.questions.question_screen
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import org.json.JSONObject
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            Navigation_Connection()
            Navigation_Connection()
        }
    }
}


