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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.example.finalquizapp.ui.theme.Category.Category
import com.example.finalquizapp.ui.theme.Category.CategoryListScreen
import com.example.finalquizapp.ui.theme.Category.ImageCard
import com.example.finalquizapp.ui.theme.FinalQuizAppTheme
import com.example.finalquizapp.ui.theme.di.AppModule
import com.example.finalquizapp.ui.theme.difficulty.DifficultyCardView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FinalQuizAppTheme {
                DifficultyCardView()

            }
        }
    }


}

