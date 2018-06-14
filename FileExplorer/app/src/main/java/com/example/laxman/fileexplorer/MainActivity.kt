package com.example.laxman.fileexplorer
import android.content.Intent
import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.util.Log
import android.widget.Toast




class MainActivity : AppCompatActivity() {

    var i : Intent? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var status = ContextCompat.checkSelfPermission(this,android.Manifest.permission.READ_EXTERNAL_STORAGE)

        if(status == PackageManager.PERMISSION_GRANTED)
        {
            i = Intent(this,SelectChoice::class.java)
            startActivity(i)
        }
        else
        {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE),0)

        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if(grantResults[0] == PackageManager.PERMISSION_GRANTED)
        {
            i = Intent(this,SelectChoice::class.java)
            startActivity(i)
        }
        else
        {
            Toast.makeText(this,"to acess you need to allow",Toast.LENGTH_LONG).show()
        }
    }





}
