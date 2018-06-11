package com.example.laxman.activitylifecycle

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("activitylifecycle","on create invoked")
    }

    override fun onStart() {
        super.onStart()
        Log.d("activitylifecycle","on start invoked")
    }

    override fun onStop() {
        super.onStop()
        Log.d("activitylifecycle","on stop invoked")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("activitylifecycle","on Restart invoked")
    }

    override fun onPause() {
        super.onPause()
        Log.d("activitylifecycle","on pause invoked")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("activitylifecycle","on Destroy invoked")
    }

    override fun onResume() {
        super.onResume()
        Log.d("activitylifecycle","on Resume invoked")
    }
}
