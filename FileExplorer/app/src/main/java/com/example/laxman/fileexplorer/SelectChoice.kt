package com.example.laxman.fileexplorer

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView


class SelectChoice : AppCompatActivity() {

    var mybox :ListView?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selectchoice)

        mybox = findViewById(R.id.box)

        mybox?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onNothingSelected(p0: AdapterView<*>?) {

                var i= Intent(this@SelectChoice,ShowActivity::class.java)
                i.putExtra("internal1","storage/emulated0/")
                i.putExtra("internal2","storage/sdcard0/")
                startActivity(i)



            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long)
            {
               if(p2 == 0)
              {
                 var i= Intent(this@SelectChoice, ShowActivity::class.java)
                  i.putExtra("internal1","storage/emulated0/")
                  i.putExtra("internal2","storage/sdcard0/")
                  startActivity(i)
              }
               if(p2 == 1)
              {
                  var i= Intent(this@SelectChoice,ShowActivity::class.java)
                  i.putExtra("internal1","storage/extsdcard/")
                  i.putExtra("internal2","storage/sdcard1/")
                  startActivity(i)
              }


            }

        }
    }
}
