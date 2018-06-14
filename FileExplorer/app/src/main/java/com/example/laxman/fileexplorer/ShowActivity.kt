package com.example.laxman.fileexplorer

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import java.io.File

class ShowActivity : AppCompatActivity() {

    var mylist:ListView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show)
        readfiles()
    }

    fun readfiles() {
        var path=intent.getStringExtra("internal1")
        var f = File(path)
        if(!f.exists())
        {
            path=intent.getStringExtra("internal2")
            f = File(path)
        }
        var values= f.list()
        var myadapter = ArrayAdapter<String>(this,R.layout.listcomponent,values)
        mylist =findViewById<ListView>(R.id.display)
        mylist?.adapter = myadapter

        Toast.makeText(this,path,Toast.LENGTH_LONG).show()
    }
}
