package com.example.finalquizapp.ui.theme.questions

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.finalquizapp.ui.theme.Api.Quiz
import com.example.finalquizapp.ui.theme.Result.FinalScreen
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("RememberReturnType")
@Composable
fun question_screen(quizs: List<Quiz>) {
    var questions: MutableList<Question> = mutableListOf()
    var count by remember { mutableIntStateOf(0) }
    var showFinishScreen by remember{ mutableStateOf(false) }

    for(i in quizs.indices){
                    var question= Question(quizs[i].question,(quizs[i].incorrect_answers+quizs[i].correct_answer).shuffled(),quizs[i].correct_answer)

        questions.add(question)

                }

    Log.e("HiGanesh", questions.toString() )
    var currentQuestionIndex by remember { mutableStateOf(0) }
    val currentQuestion = questions[currentQuestionIndex]
    val coroutineScope = rememberCoroutineScope()
    val optionBackgroundColors =
        remember { mutableStateListOf(*Array(currentQuestion.options.size) { Color.White }) }
    var timer by remember { mutableStateOf(15) }


    LaunchedEffect(key1 = currentQuestion) {
        while (timer > 0) {
            delay(1000L)
            timer--
        }


        if (timer == 0) {
            val correctIndex = currentQuestion.options.indexOf(currentQuestion.correctAnswer)
            optionBackgroundColors[correctIndex] = Color.Green

            delay(1000L)
            if (currentQuestionIndex < questions.size - 1) {
                currentQuestionIndex++

                optionBackgroundColors.fill(Color.White)
                timer = 15
            }
        }
    }
    Card(
        modifier = Modifier.fillMaxSize(), colors = CardDefaults.cardColors(
            containerColor = Color(106, 90, 224),
            contentColor = Color.White
        ),
        shape = RectangleShape
    ) {

        Card(
            modifier = Modifier.padding(start = 8.dp, top = 40.dp, end = 8.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White,
                contentColor = Color.Black
            ),
            shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
        ) {
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(start = 8.dp, end = 8.dp)) {

                Spacer(modifier = Modifier.height(30.dp))
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center){
                    Box( modifier = Modifier
                        .width(65.dp)
                        .height(65.dp)
                        .background(
                            color = Color(
                                254,
                                142,
                                161,
                                255
                            ),
                            shape = CircleShape
                        ),contentAlignment = Alignment.Center,) {
                        Text(text = "$timer", textAlign = TextAlign.Center, fontSize = 26.sp, fontWeight = FontWeight.SemiBold, color = Color.White)
                    }
                }


                Spacer(modifier = Modifier.height(50.dp))

                Text(text= "QUESTION ${currentQuestionIndex+1} OF 10", color = Color(
                    138,
                    137,
                    137,
                    255
                ), fontWeight = FontWeight.Bold, fontSize = 18.sp)

                Text(text = currentQuestion.question, fontSize = 22.sp, fontWeight = FontWeight.SemiBold)
Spacer(modifier = Modifier.height(8.dp))

                currentQuestion.options.forEachIndexed { index, option ->
                    
                    
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    OutlinedCard(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            text = option,
                            style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.SemiBold),


                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {

                                    if (option == currentQuestion.correctAnswer) {
                                        optionBackgroundColors[index] = Color.Green
                                        count++
                                        if (currentQuestionIndex == 9) {
                                            showFinishScreen = true
                                        }


                                    } else {
                                        optionBackgroundColors[index] = Color.Red

                                        val correctIndex =
                                            currentQuestion.options.indexOf(currentQuestion.correctAnswer)
                                        optionBackgroundColors[correctIndex] = Color.Green
                                        if (currentQuestionIndex == 9) {
                                            showFinishScreen = true
                                        }
                                    }


                                    coroutineScope.launch {
                                        delay(1500L)
                                        if (currentQuestionIndex < questions.size - 1) {
                                            currentQuestionIndex++



                                            optionBackgroundColors.fill(Color.White)
                                            timer = 15
                                        }
                                    }
                                }
                                .background(optionBackgroundColors[index])
                                .padding(16.dp)
                                .padding(start = 16.dp),

                        )
                    }

                }
            }
        }

    }
    if(showFinishScreen){
        FinalScreen(count = count)
    }
}


