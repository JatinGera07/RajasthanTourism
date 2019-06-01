package com.example.jatingera.raje

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main3.*
import kotlinx.android.synthetic.main.activity_main9.*
import org.jetbrains.annotations.NotNull

class Main9Activity : AppCompatActivity() {
    lateinit var questionArray : Array<String>
    // global declare -->istance variable
    lateinit var optionsArray : Array<String>
    lateinit var answersArray : Array<String>
    lateinit var life : Array<ImageView>
    lateinit var buttons:Array<Button>
    var lifecount=2
    var counter=0
    var score=0
    var i=0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main9)
        life = arrayOf(a,b,c)
        buttons= arrayOf(btn1,btn2,btn3,btn4)
        time()
        questionArray = resources.getStringArray(R.array.cquestions)
        optionsArray = resources.getStringArray(R.array.coptions)
        answersArray = resources.getStringArray(R.array.correctanswers)

        question.text = questionArray[0]
        btn1 . text = optionsArray [0]
        btn2 . text = optionsArray [1]
        btn3 . text = optionsArray [2]
        btn4 . text = optionsArray [3]
        //loadNextquestion()
        }
    fun loadNextquestion(view:View){
        checkscore(view)
        /*var countdowntimer=object : CountDownTimer(20000,1000){
            override fun onFinish() {
                loadNextquestion(view)
            }

            override fun onTick(p0: Long) {
                timerTextView.text="Time Left: ${p0/1000}"
            }

        }*/
        var handle=Handler()
        handle.postDelayed({ if(counter<4) {
            counter++
            question.text = questionArray[counter]
            btn1.text = optionsArray[4 * counter]
            btn2.text = optionsArray[4 * counter + 1]
            btn3.text = optionsArray[4 * counter + 2]
            btn4.text = optionsArray[4 * counter + 3]
            for(i in buttons)
            {
                i.setBackgroundColor(Color.WHITE)

            }
        }
        else
        {
            var intent=Intent(this,Main10Activity::class.java)
            intent.putExtra("score",score)
            startActivity(intent)

        }},4000)


    }
    fun checkscore(view: View){
        var button=findViewById<Button>(view.id)
        if(button.text==answersArray[counter]){
            score=score+10
            button.setBackgroundColor(Color.GREEN)
        }
        else{
            button.setBackgroundColor(Color.RED)
            markcorrectanswer()
            if(lifecount>=0){
                life[lifecount].visibility = View.INVISIBLE
                lifecount--
            }
            else{
                var intent=Intent(this,Main10Activity::class.java)
                intent.putExtra("score",score)
                startActivity(intent)
            }

        }


    }
    fun markcorrectanswer(){
        for (i in buttons)
        {if(i.text==answersArray[counter])
        {
            i.setBackgroundColor(Color.GREEN)
        }

        }
    }
    fun time()
    {

        //CountDownTimer class-->abstract class-->when we don't want to create any instance of a class
        var countdowntimer=object : CountDownTimer(20000,1000){
            override fun onFinish() {
                var intoo=Intent(this@Main9Activity,Main10Activity::class.java)
                intoo.putExtra("score",score)
                startActivity(intoo)

            }

            override fun onTick(p0: Long) {
                timerTextView.text="Time Left: ${p0/1000}"
            }

        }
        countdowntimer.start()
    }
}
