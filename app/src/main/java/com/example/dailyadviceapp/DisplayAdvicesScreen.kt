package com.example.dailyadviceapp

import androidx.compose.runtime.Composable
import androidx.compose.material.Text
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.dailyadviceapp.Constants.BASE_URL



@Composable
fun DisplayAdvicesScreen(
/*
    Text(
        text = "${BASE_URL}",
        fontSize = 35.sp,
        fontWeight = FontWeight.ExtraBold,
        maxLines = 1
    )

*/
    viewModel: AdviceViewModel
) {

    Text(

        text = viewModel.advice
    )


}



