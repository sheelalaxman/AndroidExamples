package com.example.laxman.simpleprofile


import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //var data = arrayListOf<String>()
        var i = Intent(this,ProfileActivity::class.java )
        var bttn =findViewById<Button>(R.id.send)

        image.setOnClickListener {
            var i1 = intent
            i1.setType("image/*")
            i1.action = Intent.ACTION_GET_CONTENT
            startActivityForResult(Intent.createChooser(i1,"select picture"),100)
        }

        bttn.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
              var name =name.text
              var mobile=mobile.text
              var mail=mail.text
              var twitter=twitter.text

             /*   data.add(0,name.toString())
                data.add(1,mobile.toString())
                data.add(2,mail.toString())
                data.add(3,twitter.toString())

                i.putExtra("database",data)
                startActivity(i)*/
                i.putExtra("name",name.toString())
                i.putExtra("mobile",mobile.toString())
                i.putExtra("mail",mail.toString())
                i.putExtra("twitter",twitter.toString())

                startActivity(i)


            }

        })
    }



}
