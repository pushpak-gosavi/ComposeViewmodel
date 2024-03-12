package com.pushpak.composeviewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel

class MainViewModel(
    val string: String
) : ViewModel() {
     var changeBackground by mutableStateOf(Color.White)
         private set

    fun changeBackgroundColor(){
        changeBackground = Color.Red
    }
}