package com.example.jatingera.raje

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        var path="android.resource://$packageName/${R.raw.trial1}"
        video.setVideoPath(path)
        video.setMediaController(MediaController(this))
        video.start()
        but1.setOnClickListener{
            var inte=Intent(this,Main3Activity::class.java)
            startActivity(inte)
        }
        but2.setOnClickListener {
            var inte=Intent(this,Main5Activity::class.java)
            startActivity(inte)

        }
        but3.setOnClickListener {
            var inte=Intent(this,Main7Activity::class.java)
            startActivity(inte)

        }
      but5.setOnClickListener {
          var inte=Intent(this,Main11Activity::class.java)
          startActivity(inte)

      }
        email.setOnClickListener {
        var intent = Intent()

        intent.action = Intent.ACTION_SEND  // data --> send --> app
        intent.type = "text/plain"       //type of your data which you are going to send MIME Types --> predefined

        // arrayOf("a", "b", "fdfdf")  --> Array<String>
        intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("RajasthanTourism@gmail.com")) // To
        intent.putExtra(Intent.EXTRA_SUBJECT, "what's your query")// Subject
        intent.putExtra(Intent.EXTRA_TEXT, "elaborate your query here") // Body
        // Remember choice
        //startActivity(Intent.createChooser(intent, "Select Anyone"))
        startActivity(intent)}
        contact.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:8130735488")
            startActivity(intent)
        }
        but7.setOnClickListener{
            var i=Intent(this,Main9Activity::class.java)
            startActivity(i)
        }
    }
    }

