package com.example.finalquizapp.ui.theme.Category

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable

fun ImageCard(category: Category, isSelected: Boolean,
              onSelected: (Category) -> Unit) {
    Card(modifier = Modifier
        .width(180.dp)
        .height(180.dp)
        .clickable { onSelected(category) }
        ,
        colors = CardDefaults.cardColors(
            containerColor = if (isSelected) Color(254, 142, 161, 255) else Color(239,238,252),
//
            contentColor = Color(106,90,224)
        ),
        shape = RoundedCornerShape(30.dp)
        ) {
        Column(modifier= Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(modifier = Modifier
                .width(100.dp)
                .height(100.dp)
                .padding(12.dp)
                .align(alignment = Alignment.CenterHorizontally)


                ,
                colors = CardDefaults.cardColors(
                    containerColor = Color.Black,
                    contentColor = Color(106,90,224)
                ),
                shape = RoundedCornerShape(36.dp),

            ) {
                Image(
                    painter = if (isSelected) painterResource(category.imageOnClick) else painterResource(category.image),


                    contentDescription = null,
                    modifier = Modifier
                        .background(if(isSelected) Color(245, 165, 181, 255) else Color.White)
                        .padding(16.dp),
                    contentScale = ContentScale.Fit

                    )
            }

            Text(text = category.name, fontSize = 26.sp, textAlign = TextAlign.Center,fontWeight = FontWeight.SemiBold,
                color = if(isSelected) Color.White else Color(106,90,224)

            )
        }
    }
}