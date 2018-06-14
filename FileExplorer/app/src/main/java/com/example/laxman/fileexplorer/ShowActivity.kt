package com.example.laxman.fileexplorer

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_show.*
import java.io.File

class ShowActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show)
       // readFiles()
    }

   /* private fun readFiles() {
        var path=intent.getStringExtra("internal1")
        var f= File(path)

        if(!f.exists())
        {
            path=intent.getStringExtra("internal2")
            f= File(path)
        }
        var values = f.list()

        var adapter = ArrayAdapter<String>(this,R.layout.listcomponent,values)

        list.adapter = adapter
    }*/
}
