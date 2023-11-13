package com.example.finalquizapp.ui.theme.difficulty

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.finalquizapp.ui.theme.Category.ImageCard
import com.example.finalquizapp.ui.theme.Category.categoreis


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DifficultyCardView() {
    var selectedDifficulty by remember { mutableStateOf("") }
    val difficulties = listOf("Easy", "Medium", "Difficult")


    Scaffold(containerColor = Color(106, 90, 224),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Choose Difficulty",
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        fontSize = 26.sp
                    )
                },


                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color(106, 90, 224),
                    titleContentColor = Color.White,
                ),
            )
        }, content = {
            Card(
                modifier = Modifier.padding(start = 8.dp, top = 30.dp, end = 8.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(106, 90, 224), //Card background color
                    contentColor = Color(106, 90, 224)  //Card content color,e.g.text
                )
            ) {
                Column {


                    Card(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(it),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White, //Card background color
                            contentColor = Color(106, 90, 224),
                            //Card content color,e.g.text
                        ),
                        shape = RoundedCornerShape(
                            topEnd = 16.dp,
                            topStart = 16.dp,
                            bottomEnd = 0.dp,
                            bottomStart = 0.dp
                        )
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(it),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,


                            ) {
                            difficulties.forEach { difficulty ->
                                Card(
                                    modifier = Modifier
                                        .weight(1f)
                                        .fillMaxWidth()
                                        .padding(8.dp)
                                        .clickable { selectedDifficulty = difficulty },
                                    colors = CardDefaults.cardColors(
                                        containerColor = if (selectedDifficulty == difficulty) Color(
                                            254,
                                            142,
                                            161,
                                            255
                                        ) else Color(239, 238, 252),
//            containerColor = Color(239,238,252), //Card background color
                                        contentColor = if(selectedDifficulty==difficulty) Color.White else Color(
                                            106,
                                            90,
                                            224
                                        )  //Card content color,e.g.text
                                    ),
                                ) {
                                    Box (modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                                        Text(
                                            textAlign = TextAlign.Center,
                                            text = difficulty,
                                            modifier = Modifier.padding(16.dp), fontSize = 32.sp, fontWeight = FontWeight.Bold,
                                            style = MaterialTheme.typography.bodyLarge
                                        )
                                    }

                                }
                            }
                            Button(
                                onClick = { /*TODO*/ }, modifier = Modifier
                                    .height(70.dp)
                                    .fillMaxWidth()
                                    .padding(8.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(106, 90, 224),
                                    contentColor = Color.White
                                ), shape = RoundedCornerShape(16.dp)
                            ) {
                                Text(text = "Next")

                            }

                        }

                    }


                }
            }
        }
    )
}


