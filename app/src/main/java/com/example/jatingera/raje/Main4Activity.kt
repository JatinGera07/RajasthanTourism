package com.example.jatingera.raje
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.animation.AnimationUtils
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.jatingera.raje.R.drawable.amerfort
import kotlinx.android.synthetic.main.activity_main4.*

class Main4Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
        var imageurl = "http://api.openweathermap.org/data/2.5/forecast?id=1275665&APPID=984465f2d2d77755804deeb020359a0b"
        val que = Volley.newRequestQueue(this)
        var animation= AnimationUtils.loadAnimation(this,R.anim.fadein)

        amir.startAnimation(animation)

        val req = JsonObjectRequest(Request.Method.GET, imageurl, null,
                Response.Listener {
                    response ->
                    var array = response.getJSONArray("list")

                    for(i in 0 until array.length()) {

                        var temp = array.getJSONObject(i) // 0
                                .getJSONObject("main")
                                .get("temp")
                        tempmin.text=temp.toString()
                        /*var temp1 = array.getJSONObject(i) // 0
                                .getJSONObject("main")
                                .get("temp_max")
                        tempmax.text=temp1.toString()

                        */var hue = array.getJSONObject(i) // 0
                                .getJSONObject("main")
                                .get("humidity")
                        humidity.text=hue.toString()

                        //  var jsonObj = array.getJSONObject(i)
//                                        var imagesObj = jsonObj.getJSONObject("images")
//                                        var width = imagesObj.getJSONObject("fixed_width")
//                                        Log.i("url : ", width.get("url").toString() )
                    }
                },
                Response.ErrorListener { error->
                    Toast.makeText(this, "Exception ${error.message} ", Toast.LENGTH_LONG).show()
                })

        que.add(req)

    }
}
