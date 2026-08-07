package com.example.dailyadviceapp

import androidx.compose.runtime.Composable
import androidx.compose.material.Text


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



