package com.example.finalquizapp.ui.theme.Category

import android.annotation.SuppressLint

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryListScreen(onButtonClick: (Int) -> Unit){

    var selectedCategory by remember { mutableStateOf<Category?>(null) }


    Scaffold(containerColor = Color(106,90,224),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "Choose Category",fontWeight = FontWeight.Bold, textAlign = TextAlign.Center, fontSize = 26.sp)
                },


                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color(106,90,224),
                    titleContentColor = Color.White,
                ),
            )
        }, content = {
            Card (
                modifier = Modifier.padding(start = 8.dp, top = 30.dp,end=8.dp),colors = CardDefaults.cardColors(
                    containerColor = Color(106,90,224),
                    contentColor = Color(106,90,224)
                )
            ){
                Column {


                    Card (modifier = Modifier
                        .fillMaxSize()
                        .padding(it),colors = CardDefaults.cardColors(
                        containerColor = Color.White,
                        contentColor = Color(106,90,224) ,

                    )
                    , shape = RoundedCornerShape(topEnd = 16.dp, topStart = 16.dp, bottomEnd = 0.dp, bottomStart = 0.dp)
                    ){
                        LazyVerticalGrid(columns = GridCells.Fixed(2),
                            contentPadding = PaddingValues(18.dp),
                            verticalArrangement = Arrangement.spacedBy(15.dp),
                            modifier = Modifier.weight(1f),
                            horizontalArrangement = Arrangement.spacedBy(15.dp)){
                            items(categoreis){ item->

                                ImageCard(category =item, isSelected = item==selectedCategory, onSelected = {selectedCategory=it} )
                            }
                        }


                            Button(
                                onClick = { if(selectedCategory!=null) {

                                    onButtonClick(selectedCategory!!.number)
                                }

                                }, modifier = Modifier
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
    )
}