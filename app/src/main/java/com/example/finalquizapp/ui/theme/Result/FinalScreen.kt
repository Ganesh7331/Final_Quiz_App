package com.example.finalquizapp.ui.theme.Result

import android.annotation.SuppressLint
import android.content.ComponentName
import android.content.ContentProvider
import android.content.Intent
import android.content.pm.PackageManager
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.finalquizapp.R
import com.example.finalquizapp.ui.theme.History.HistoryViewModel
import com.example.finalquizapp.ui.theme.SharedState
import com.example.finalquizapp.ui.theme.questions.MainViewModel

//import com.example.finalquizapp.ui.theme.Navigation.Navigation_Connection


@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun FinalScreen(count:Int) {
    val context= LocalContext.current
    val viewModel:HistoryViewModel= hiltViewModel()

    viewModel.addItemToHistory(count,SharedState.historyList.value.name)




    val packageManager: PackageManager = context.packageManager
    val intent: Intent = packageManager.getLaunchIntentForPackage(context.packageName)!!
    val componentName: ComponentName = intent.component!!
    val restartIntent: Intent = Intent.makeRestartActivityTask(componentName)


    
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color(106, 90, 224)),verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
            Text(text = "Result", color = Color.White, fontSize = 26.sp, fontWeight = FontWeight.Bold)
        }
        Image(painter = painterResource(R.drawable.ic_trophy), contentDescription ="Trophy"
        , modifier = Modifier
                .width(400.dp)
                .height(300.dp)
                .padding(8.dp))
        
        Spacer(modifier = Modifier.height(8.dp))

        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
            Text(text = "Hey,Congratulations", color = Color.White, fontSize = 26.sp, fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
            Text(text = "Your score is $count out of 10", color = Color(230, 226, 226, 255), fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick ={
            context.startActivity(restartIntent)
            Runtime.getRuntime().exit(0)
        }, modifier = Modifier.padding(16.dp), colors = ButtonDefaults.buttonColors(
            containerColor = Color.White,
            contentColor = Color(106, 90, 224)
        )) {
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Text(text = "Finish", color = Color(106, 90, 224), fontSize = 26.sp, fontWeight = FontWeight.Bold)
            }
        }

        
    }

}