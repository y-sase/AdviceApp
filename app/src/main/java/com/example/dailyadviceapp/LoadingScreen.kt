package com.example.dailyadviceapp

import android.app.Activity
import android.content.Intent
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.SemanticsProperties.Text
import androidx.compose.ui.text.input.KeyboardType.Companion.Text
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.dailyadviceapp.ui.theme.ScreenRoute
import com.example.dailyadviceapp.use_case.DisplayAdviceActivity


@Composable
    fun LoadingScreen(
        viewModel: AdviceViewModel,
        navController: NavController
    ) {

    //  println("LoadingScreenが表示された")

    /*
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
*/
    val context =
        LocalContext.current //ComposeからAndroidの「Context」(Activityを起動する, Toastを表示する,リソースにアクセスする時に必要なもの） を取得、Intentを使ってActivityを起動するときに必要



    LaunchedEffect(Unit) {//画面が表示された瞬間に中の処理を1回だけ実行
        if (viewModel.query.isBlank()) {//queryが空かどうかを確認する
            viewModel.loadAdvice {

                val intent = Intent(//Intentオブジェクト作成
                    context,//今いるActivityの情報、「どこから起動するのか」を指定
                    DisplayAdviceActivity::class.java
                )

                intent.putExtra(//取得したアドバイスをIntentに入れる
                    "advice",
                    viewModel.advice
                )

                intent.putExtra(//取得したアドバイスIDをIntentに入れる
                    "id",
                    viewModel.adviceId
                )

                context.startActivity(intent)//実際に画面遷移
                navController.popBackStack()//今いる画面を履歴から消して、1つ前の画面に戻る

            }
            }else {
                viewModel.loadAdviceById(
                    viewModel.query.toInt()
                ) {
                    val intent = Intent(
                        context,
                        DisplayAdviceActivity::class.java
                    )
                    intent.putExtra(
                        "advice",
                        viewModel.advice
                    )
                    intent.putExtra(
                        "id",
                        viewModel.adviceId
                    )
                    context.startActivity(intent)
                    navController.popBackStack()
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

