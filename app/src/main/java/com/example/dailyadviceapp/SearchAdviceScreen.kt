package com.example.dailyadviceapp

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun SearchAdviceScreen(
    viewModel: AdviceViewModel,
    navController: NavController,//画面遷移
) {
  //  val viewModel: AdviceViewModel = hiltViewModel()//Hiltさん、AdviceViewModelを作ってください！
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = 150.dp
            )
    ) {
        Text(
            text = "今日の一言",
            fontSize = 35.sp,
            fontWeight = FontWeight.ExtraBold,
            maxLines = 1
        )


        //検索欄


        Spacer(modifier = Modifier.height(80.dp))

        //取得ボタン
        Button(
            onClick = {
                viewModel.loadAdvice()
                navController.navigate(ScreenRoute.DisplayAdviceScreen.route)
                      },
            modifier = Modifier
                .height(50.dp)
                .width(250.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xFFF85F6A)
            ),


            ) {
            Text(
                text = "取得する",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
            )
        }

    }
}
