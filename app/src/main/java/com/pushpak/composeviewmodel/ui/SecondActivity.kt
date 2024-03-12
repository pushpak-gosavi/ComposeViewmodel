package com.pushpak.composeviewmodel.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.pushpak.composeviewmodel.R

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        Log.d("CNF_Change", "onCreate_2()")

    }
    override fun onStart() {
        Log.d("CNF_Change", "onStart_2()")
        super.onStart()
    }

    override fun onResume() {
        Log.d("CNF_Change", "onResume_2()")
        super.onResume()
    }

    override fun onPause() {
        Log.d("CNF_Change", "onPause_2()")
        super.onPause()
    }

    override fun onRestart() {
        Log.d("CNF_Change", "onRestart_2()")
        super.onRestart()
    }

    override fun onStop() {
        Log.d("CNF_Change", "onStop_2()")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d("CNF_Change", "onDestroy_2()")
        super.onDestroy()
    }
}