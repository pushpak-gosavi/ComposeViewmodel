package com.pushpak.composeviewmodel

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.ViewModelInitializer
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.viewModelFactory
import com.pushpak.composeviewmodel.ui.SecondActivity
import com.pushpak.composeviewmodel.ui.theme.ComposeViewmodelTheme

@Suppress("UNCHECKED_CAST")
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /**
         * We need the factory method when we want call constructor with value
         * view model factory method
         * if we not want to pass the parameter constructor the only use the
         * viewModels<ViewModelClass>()
         */
        /*
        val mainViewModel by viewModels<MainViewModel>(
                    factoryProducer = {
                        object : ViewModelProvider.Factory{
                            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                                return MainViewModel(
                                    string = "Hello Pushpak"
                                ) as T
                            }
                        }
                    }
                )
         */
        setContent {
            ComposeViewmodelTheme {
                /**
                 * Using the jetpack compose View Model library
                 */
                val mainViewModel = viewModel<MainViewModel>(
                    factory = object : ViewModelProvider.Factory {
                        override fun <T : ViewModel> create(modelClass: Class<T>): T {
                            return MainViewModel(
                                string = "Hello World"
                            ) as T
                        }
                    }
                )
                // A surface container using the 'background' color from the theme
                Surface {
                        CenterButton(mainViewModel = mainViewModel)
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
fun CenterButton(mainViewModel: MainViewModel){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = mainViewModel.changeBackground),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {

        Button(
            //modifier = Modifier.size(width = 100.dp, height = 30.dp),
            onClick = {
                mainViewModel.changeBackgroundColor()
            }) {
            Text(text = "Change BG")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    ComposeViewmodelTheme {
        CenterButton(mainViewModel = MainViewModel(string = "Hello"))
    }
}