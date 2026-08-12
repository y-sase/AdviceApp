package com.example.dailyadviceapp.use_case


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.dailyadviceapp.DisplayAdvicesScreen

class DisplayAdviceActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {//Activityが起動した瞬間に呼ばれる関数
        super.onCreate(savedInstanceState)//親クラス(ComponentActivity)の初期化処理、Activityではほぼ必ず書く

        val advice = intent.getStringExtra("advice") ?: ""//Intentからadviceというデータを取り出している,もし取り出せなかったら空文字""
        val id = intent.getIntExtra("id", 0)//Intentからidというデータを取り出している,データが見つからなかった場合の初期値0

        setContent {
            DisplayAdvicesScreen(
                advice = advice,
                id = id,
            )
        }
    }
}