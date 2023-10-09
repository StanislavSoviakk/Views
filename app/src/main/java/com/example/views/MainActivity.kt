package com.example.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.views.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val linearView = binding.linearView

        (0..20).forEach {
            linearView.addItem("$it item")
        }
    }
}