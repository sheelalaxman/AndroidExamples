package com.example.laxman.navapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView

class ShowActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.show_activity)

        var i =this.intent
        var s=i.getStringExtra("per_name")
        var s1=findViewById<TextView>(R.id.show)
        s1.text = s
    }
}