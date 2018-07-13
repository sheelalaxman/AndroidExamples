package com.lmndevelopers.cntproviders

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import android.widget.AdapterView
import android.widget.SimpleCursorAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var cr = contentResolver
        var c=cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)
        var adapter=SimpleCursorAdapter(this,R.layout.indiview,c, arrayOf(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,ContactsContract.CommonDataKinds.Phone.NUMBER),
                intArrayOf(R.id.name,R.id.number),0)
        lview.adapter = adapter

        lview?.onItemClickListener = object : AdapterView.OnItemClickListener {
            override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                var phones = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME);
                var list= mutableListOf<String>()
                while (phones.moveToNext()) {
                    var name = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                    var phoneNumber = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                    list.add(phoneNumber)
                }
               var i = Intent(Intent.ACTION_CALL)
                //Toast.makeText(this@MainActivity,list.get(p2),Toast.LENGTH_LONG).show()
                i.data = Uri.parse("tel:${list.get(p2)}")
                startActivity(i)

            }

        }
    }
}
