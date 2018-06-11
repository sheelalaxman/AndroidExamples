package com.example.laxman.myclickapp


import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        clck.setOnClickListener {
            val str = textvalue.text.toString()
            result.text = str
        }

        clear.setOnClickListener {
            textvalue.text = Editable.Factory.getInstance().newEditable("")
            result.text = ""
        }

    }
}
