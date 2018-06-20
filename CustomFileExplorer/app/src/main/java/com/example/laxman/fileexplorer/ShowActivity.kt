package com.example.laxman.fileexplorer


import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import java.io.File
import java.util.*

class ShowActivity : AppCompatActivity() {

    var stack : Stack<String>? = null
    var mylist:ListView?=null
    var back:Button? = null
    var path:String? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show)
        stack = Stack()
        path=intent.getStringExtra("internal1")
        readfiles(path)

        findViewById<Button>(R.id.back).setOnClickListener {
            back()
        }
    }

    fun back()
    {
        stack?.pop()
        if(stack!!.size == 0)
        {
            var i = Intent(this,SelectChoice::class.java)
            startActivity(i)

        }
        else
        {

            path = stack?.pop()
            readfiles(path)
        }
    }



    fun readfiles(p : String?) {

        var f = File(p)
        if(!f.exists())
        {
            path=intent.getStringExtra("internal2")
            f = File(p)
        }
        path= p
        stack?.push(path)
       var values= f.list()
        mylist =findViewById<ListView>(R.id.display)
        mylist?.adapter = MyAdapter(this,path,f)



       mylist?.onItemClickListener = object : AdapterView.OnItemClickListener {
            override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
               path = path+values?.get(p2)+"/"
                stack?.push(path.toString())
                f = File(path)
                if(f.isDirectory)
                {
                    values = f.list()
                    mylist = findViewById<ListView>(R.id.display)
                    mylist?.adapter = MyAdapter(this@ShowActivity,path,f)

                }
                else
                {
                    Toast.makeText(this@ShowActivity,"this is file",Toast.LENGTH_LONG)
                }

            }


        }

    }
}
