package com.lmndevelopers.notemaker

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class RegisterFrag : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        var v= inflater!!.inflate(R.layout.register_frag,container,false)
        return v!!
    }

}