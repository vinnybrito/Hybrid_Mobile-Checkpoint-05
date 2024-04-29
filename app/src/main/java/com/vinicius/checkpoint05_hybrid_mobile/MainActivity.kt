package com.vinicius.checkpoint05_hybrid_mobile

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.vinicius.checkpoint05_hybrid_mobile.bmiactivity.CalculateBmiActivity
import com.vinicius.checkpoint05_hybrid_mobile.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupListener()
    }

    private fun setupListener() {
        binding.btnBmiActivity.setOnClickListener {
            startActivity(Intent(this, CalculateBmiActivity::class.java))
        }
    }

}