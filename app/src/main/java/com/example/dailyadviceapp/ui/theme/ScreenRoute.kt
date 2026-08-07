//画面遷移の行き先一覧

package com.example.dailyadviceapp.ui.theme

sealed class ScreenRoute(val route: String){
    object SearchAdviceScreen : ScreenRoute("search_advice_screen")
    object DisplayAdviceScreen : ScreenRoute("display_advice_screen")
    object LoadingScreen : ScreenRoute("loading_screen")
}
