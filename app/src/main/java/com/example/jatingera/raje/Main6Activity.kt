package com.example.jatingera.raje

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main6.*

class Main6Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)
        register.setOnClickListener {
            var inte= Intent(this,Main7Activity::class.java);
            startActivity(inte);

        }
           }
}
