package com.example.stateflow

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewmodel:ViewModel() {

    private val counter:MutableStateFlow<Int> = MutableStateFlow(0)

    val counter1:StateFlow<Int> = counter

    fun incrementState()
    {
        counter.value++

    }

    fun decrementState()
    {
        counter.value--

    }
}