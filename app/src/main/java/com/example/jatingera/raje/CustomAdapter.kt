package com.example.jatingera.raje
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class CustomAdapter(listActivity:Main8Activity, Name: Array<String>) : BaseAdapter() {

    var profile = Name

    var lstActivity = listActivity

    var layoutInflater : LayoutInflater = lstActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var view = layoutInflater.inflate(R.layout.custom_layout, p2, false)
        var name3=view.findViewById<TextView>(R.id.Nameee)
        var contact3=view.findViewById<TextView>(R.id.contactsss)

        name3.text=profile[p0]
        return view
    }

    override fun getItem(p0: Int): Any {
        return profile[p0]
    }

    override fun getItemId(p0: Int): Long {
        return 2
    }

    override fun getCount(): Int {
        return profile.size
    }


}