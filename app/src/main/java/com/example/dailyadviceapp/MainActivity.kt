package com.example.dailyadviceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DailyAdviceAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    //SearchAdviceScreen()


                }
                val navController = rememberNavController()//画面遷移を管理するオブジェクト

                val adviceViewModel: AdviceViewModel = hiltViewModel()//hiltからViewModel取得
                NavHost(                                   //画面遷移のルールを定義
                    navController = navController,
                    startDestination = ScreenRoute.SearchAdviceScreen.route,

                ) {
                    //名言検索画面
                    composable(route = ScreenRoute.SearchAdviceScreen.route) {
                        SearchAdviceScreen(
                            navController= navController,
                            viewModel = adviceViewModel
                        )
                    }


                    //名言詳細表示画面

                    composable(route = ScreenRoute.DisplayAdviceScreen.route) {
                        DisplayAdvicesScreen(
                            viewModel = adviceViewModel
                        )


                    }
                }
            }
        }
    }
}


