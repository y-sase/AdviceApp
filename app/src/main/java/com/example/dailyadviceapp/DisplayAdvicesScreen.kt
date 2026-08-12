package com.example.dailyadviceapp

import androidx.compose.foundation.layout.Column
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
   // viewModel: AdviceViewModel
    advice: String,
    id: Int

) {

    /*
    Text(

        text =
            viewModel.advice
    )
   */
        Column {
            Text(text = "ID: $id　のアドバイスです")
            Text(text = advice)
        }
    }







