package com.example.laxman.navapp

import android.content.Intent
import android.content.IntentSender
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import android.widget.EditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun go(v : View)
    {
        var value : EditText  = findViewById(R.id.textvalue)
        var i = Intent(this,ShowActivity::class.java )
        i.putExtra("per_name",value.text.toString())
        startActivity(i)
    }
}
