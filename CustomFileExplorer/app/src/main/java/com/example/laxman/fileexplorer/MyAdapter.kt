package com.example.laxman.fileexplorer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import java.io.File

class MyAdapter : BaseAdapter
{

    var files : Array<File>? = null
    var inflater : LayoutInflater? =null
    var file : File? =null
    var v : View? =null

    constructor(activity: ShowActivity ,path: String?,f : File?)
    {
       files =  f!!.listFiles()
       inflater = LayoutInflater.from(activity)
    }
    override fun getCount(): Int {

        return files!!.size

    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

        if(files!!.get(p0).isDirectory) {

             v = inflater!!.inflate(R.layout.dir_view, null)
             var fname = v!!.findViewById<TextView>(R.id.fname)
             fname.text = files!!.get(p0).name

        }
        else
        {
             v = inflater!!.inflate(R.layout.file_view, null)
             var fname = v!!.findViewById<TextView>(R.id.fname1)
            var fsize = v!!.findViewById<TextView>(R.id.fsize)
             fname.text = files!!.get(p0).name
             fsize.text = File(files!!.get(p0).path.toString()).length().toString() + "  bytes"


        }

        return v!!
      }

    override fun getItem(p0: Int): Any {
        return 0
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }


}