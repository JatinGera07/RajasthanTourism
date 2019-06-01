package com.example.jatingera.raje

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_main12.*

class Main12Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main12)
        var anim=AnimationUtils.loadAnimation(this,R.anim.fadein)
        camel.startAnimation(anim)
    }
}
