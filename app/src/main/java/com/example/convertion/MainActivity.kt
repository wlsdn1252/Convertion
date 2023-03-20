 package com.example.convertion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.convertion.databinding.ActivityMainBinding

 class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val inputEditText = binding.inputEditText
        val outputTextView = binding.outputtextView
        val inputUnitTextView = binding.inputUnitTextView
        val outputUnitTextView = binding.outputUnitTextView

    }
}