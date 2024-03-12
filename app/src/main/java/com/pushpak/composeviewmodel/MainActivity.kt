package com.pushpak.composeviewmodel

import android.os.Bundle
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
        setContent {
            ComposeViewmodelTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = mainViewModel.changeBackground
                ) {
                    Button(onClick = { 
                        mainViewModel.changeBackgroundColor()
                    }) {
                        Text(text = "Change BG")
                    }
                }
            }
        }
    }
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