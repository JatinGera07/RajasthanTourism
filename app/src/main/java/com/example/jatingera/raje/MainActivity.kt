package com.example.jatingera.raje

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var hand= Handler()
        hand.postDelayed(Runnable {var inte= Intent(this,Main2Activity::class.java)
            startActivity(inte)
        finish()},5000)

    }
}
