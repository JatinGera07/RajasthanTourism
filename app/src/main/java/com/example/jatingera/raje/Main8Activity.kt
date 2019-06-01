package com.example.jatingera.raje

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.provider.ContactsContract
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_main8.*
import kotlin.math.log

class Main8Activity : AppCompatActivity() {

    lateinit var firebaseDatabase: FirebaseDatabase
    lateinit var databaseReference: DatabaseReference
    var firebaseUser: FirebaseUser?=null
    lateinit var firebaseAuth: FirebaseAuth

companion object {
    var namelist= arrayOf<String>("","","","","","","","","","","","","","")
    var i=0;

}

    lateinit var arrayAdapter : ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main8)
var Handler=Handler()
        firebaseAuth= FirebaseAuth.getInstance()
        firebaseDatabase= FirebaseDatabase.getInstance()
        databaseReference=firebaseDatabase.getReference("userdata")
     //   firebaseUser= firebaseAuth.currentUser!!
        //   databaseReference.addValueEventListener(object :ValueEventListener{
        var res=intent
        var uiddd=res.getStringExtra("uidd")
         databaseReference.child(uiddd).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(p0: DataSnapshot) {
                /* for(p01 in p0.children){

                 }
                */
                namelist[i]=(p0.child("name").value.toString())
                //contactlist.add(p0.child("contact").value.toString())
               i++
            }

            override fun onCancelled(p0: DatabaseError) {
                //failed to read value
            }

        })
        listView.adapter = CustomAdapter(this@Main8Activity,namelist)
Toast.makeText(this,"Your application is pending and we will try to contact you later",Toast.LENGTH_LONG).show()
    }
}
