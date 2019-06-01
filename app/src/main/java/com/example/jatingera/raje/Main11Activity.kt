package com.example.jatingera.raje

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main11.*

class Main11Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main11)
        but211.setOnClickListener {
            var inte=Intent(this,Main12Activity::class.java)
            startActivity(inte)
        }
    }
}
