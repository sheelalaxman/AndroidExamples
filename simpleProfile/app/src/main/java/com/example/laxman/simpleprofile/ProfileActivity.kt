package com.example.laxman.simpleprofile

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        var i=this.intent
        var name = i.getStringExtra("name")
        var mobile = i.getStringExtra("mobile")
        var mail = i.getStringExtra("mail")
        var twitter = i.getStringExtra("twitter")

        this.name.text = name.toString()
        this.phonevalue.text = mobile
        this.mailvalue.text = mail
        this.twittervalue.text =  twitter

        this.mail.setOnClickListener {
            var i = packageManager.getLaunchIntentForPackage("com.google.android.gm")
            if(i != null)
            {
              startActivity(i)
            }
            else
            {
                var i1 = Intent()
                i1.action =Intent.ACTION_VIEW
                i1.data =Uri.parse("https://play.google.com/store/apps/details?id=com.google.android.gm")
                startActivity(i1)
            }
        }

        this.phone.setOnClickListener {
                var i1 = Intent()
                i1.action =Intent.ACTION_DIAL
                i1.data =Uri.parse("tel:" + mobile)
                startActivity(i1)

        }
        this.twitter.setOnClickListener {
            var i = packageManager.getLaunchIntentForPackage("com.twitter.android")
            if(i != null)
            {
                startActivity(i)
            }
            else
            {
                var i1 = Intent()
                i1.action =Intent.ACTION_VIEW
                i1.data =Uri.parse("https://play.google.com/store/apps/details?id=com.twitter.android")
                startActivity(i1)
            }
        }




    }
}
