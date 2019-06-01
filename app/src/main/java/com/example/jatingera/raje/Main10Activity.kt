package com.example.jatingera.raje

import android.content.Context
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main10.*
import kotlinx.android.synthetic.main.activity_main4.*

class Main10Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main10)
        var receivingIntent=getIntent()
        var score=receivingIntent.getIntExtra("score",0)
        yourscore.text="your score is $score" //shared preference-->for highest score(to store state when last time app open)
        var readpreferences=getSharedPreferences("score",Context.MODE_PRIVATE)
        var highestscore= readpreferences.getInt("highestscore",0)

        if(score>highestscore) {

            //saving data into shared preference
            var sharedpreference: SharedPreferences.Editor = getSharedPreferences("score", Context.MODE_PRIVATE).edit()
            sharedpreference.putInt("highestscore", score)
            sharedpreference.apply()//save into the file
            highestscoretext.text="Highest score: $score"

        }
        else{
            highestscoretext.text="Highest score: $highestscore"

        }

    }
}
