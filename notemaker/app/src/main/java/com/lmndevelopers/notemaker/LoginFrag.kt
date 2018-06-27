package com.lmndevelopers.notemaker

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast

class LoginFrag: Fragment()
{
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        var v = inflater!!.inflate(R.layout.login_frag,container,false)

        v.findViewById<Button>(R.id.login).setOnClickListener {

            Toast.makeText(activity,"Login page is on progress",Toast.LENGTH_LONG).show()


        }
        v.findViewById<Button>(R.id.register).setOnClickListener {

            var fragment = fragmentManager
            var tran =fragment.beginTransaction()
            tran.replace(R.id.frag1,RegisterFrag())
            tran.commit()
        }
        return v!!
    }

}