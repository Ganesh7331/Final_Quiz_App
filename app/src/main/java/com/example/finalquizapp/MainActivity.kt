package com.example.finalquizapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.finalquizapp.ui.theme.Database.HistoryItem
import com.example.finalquizapp.ui.theme.History.HistoryListItem
import com.example.finalquizapp.ui.theme.History.history_item
import com.example.finalquizapp.ui.theme.History.history_screen
import com.example.finalquizapp.ui.theme.Login.loginScreen
import com.example.finalquizapp.ui.theme.Navigation.MyApp
//import com.example.finalquizapp.ui.theme.Navigation.Navigation_Connection
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            Navigation_Connection()
            MyApp()
//            loginScreen()
//            history_screen()
//            val navController = rememberNavController()
//            history_screen(navController)
//            val historyItem= HistoryListItem("3",9,"easy")
//            history_item(1,historyItem)
        }
    }
}


