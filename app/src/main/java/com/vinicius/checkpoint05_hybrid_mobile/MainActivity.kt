package com.vinicius.checkpoint05_hybrid_mobile

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.vinicius.checkpoint05_hybrid_mobile.databinding.ActivityMainBinding
import com.vinicius.checkpoint05_hybrid_mobile.ui.calculateimc.CalculateBmiActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupListeners()
    }

    private fun setupListeners() {
        binding.btnBmiActivity.setOnClickListener {
            startActivity(Intent(this, CalculateBmiActivity::class.java))
        }
    }
}