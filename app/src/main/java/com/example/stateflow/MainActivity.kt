package com.example.stateflow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.stateflow.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.collect

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val mainViewModel:MainViewmodel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        init()

        counterResult()

        //setContentView(R.layout.activity_main)


    }

    private fun counterResult() {
       lifecycleScope.launchWhenStarted {
           mainViewModel.counter1.collect{ counter ->
               binding.ResultTV.text=counter.toString()
       }
        }
    }

    private fun init()
    {
        binding.BtnPlus.setOnClickListener {
            mainViewModel.incrementState()
        }
        binding.BtnMinus.setOnClickListener {
            mainViewModel.decrementState()
        }
    }



}