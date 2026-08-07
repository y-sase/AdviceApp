package com.example.dailyadviceapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerIconDefaults.Text
import androidx.compose.ui.semantics.SemanticsProperties.Text
import androidx.compose.ui.text.input.KeyboardType.Companion.Text
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.dailyadviceapp.ui.theme.ScreenRoute



@Composable
    fun LoadingScreen(
        viewModel: AdviceViewModel,
        navController: NavController
    ) {

    println("LoadingScreenが表示された")

    LaunchedEffect(Unit) {//画面が表示された瞬間に処理を実行するためのもの
        viewModel.loadAdvice {
            navController.navigate(//画面遷移
                ScreenRoute.DisplayAdviceScreen.route
            ) {
                popUpTo(ScreenRoute.LoadingScreen.route) {//画面履歴（バックスタック）を消すための機能
                    inclusive = true
                }

            }
        }
    }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {

            CircularProgressIndicator()//ぐるぐる回るローディングマーク

            Spacer(
                modifier = Modifier.height(16.dp)
            )


        }
    }

