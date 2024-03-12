package com.pushpak.composeviewmodel

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.ViewModelInitializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.pushpak.composeviewmodel.ui.SecondActivity
import com.pushpak.composeviewmodel.ui.theme.ComposeViewmodelTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /**
         * We need the factory method when we want call constructor with value
         * view model factory method
         * if we not want to pass the parameter constructor the only use the
         * viewModels<ViewModelClass>()
         */
//        val mainViewModel by viewModels<MainViewModel>(
//             factoryProducer = {
//                 object : ViewModelProvider.Factory{
//                     override fun <T : ViewModel> create(modelClass: Class<T>): T {
//                         return MainViewModel(
//                             string = "Hello Pushpak"
//                         ) as T
//                     }
//                 }
//             }
        //)
        val mainViewModel = MainViewModel("Hello")
        setContent {
            ComposeViewmodelTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = mainViewModel.changeBackground
                ) {
                    Button(onClick = { 
                        //mainViewModel.changeBackgroundColor()
                        Intent(this, SecondActivity::class.java).also {
                            startActivity(it)
                        }
                    }) {
                        Text(text = "Change BG")
                    }
                }
            }
        }
        Log.d("CNF_Change", "onCreate()")
    }

    override fun onStart() {
        Log.d("CNF_Change", "onStart()")
        super.onStart()
    }

    override fun onResume() {
        Log.d("CNF_Change", "onResume()")
        super.onResume()
    }

    override fun onPause() {
        Log.d("CNF_Change", "onPause()")
        super.onPause()
    }

    override fun onRestart() {
        Log.d("CNF_Change", "onRestart()")
        super.onRestart()
    }

    override fun onStop() {
        Log.d("CNF_Change", "onStop()")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d("CNF_Change", "onDestroy()")
        super.onDestroy()
    }

    /**
     * When Configuration change that time
     * onPause(), onStop(), onDestroy(), onCreate(), onStart(), onResume() methods are called
     */
    /**
     * When the application goes to the background then that time
     * onPause(), onStop(), onRestart(), onStart(), onResume()
     */
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeViewmodelTheme {
        Greeting("Android")
    }


}