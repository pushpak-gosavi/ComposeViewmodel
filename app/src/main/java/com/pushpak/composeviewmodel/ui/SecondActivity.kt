package com.pushpak.composeviewmodel.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import com.pushpak.composeviewmodel.R
import com.pushpak.composeviewmodel.ui.theme.ComposeViewmodelTheme

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeViewmodelTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    Text(text = "Second Activity")
                }
            }
            //setContentView(R.layout.activity_second)
            Log.d("CNF_Change", "onCreate_2()")

        }
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