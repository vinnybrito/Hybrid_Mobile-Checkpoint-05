package com.vinicius.checkpoint05_hybrid_mobile.bmi

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.vinicius.checkpoint05_hybrid_mobile.MainActivity
import com.vinicius.checkpoint05_hybrid_mobile.R
import com.vinicius.checkpoint05_hybrid_mobile.databinding.ActivityResultBmiBinding

class BmiResultActivity: AppCompatActivity() {
    private lateinit var binding: ActivityResultBmiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBmiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getDataFromCalculateBmiActivity()
        setupListeners()
    }

    private fun getDataFromCalculateBmiActivity() {
        val bundle = intent.extras
        if (bundle != null) {
            val weight = bundle.getDouble("weight")
            val height = bundle.getDouble("height")

            binding.txvWeightInformation.text = getString(
                R.string.txv_weight_information,
                String.format("%.1f", weight)
            )
            binding.txvHeightInformation.text = getString(
                R.string.txv_height_information,
                String.format("%.1f", height)
            )

            calculateBmi(weight, height)
        }
    }

    private fun calculateBmi(weight: Double, height: Double) {
        val bmi = weight / (height * height)

        if (bmi < 20) {
            binding.txvResult.setText(R.string.bmi_below_weight)
            binding.txvResult.setTextColor(ContextCompat.getColor(this, R.color.blue))
        } else if (bmi < 25) {
            binding.txvResult.setText(R.string.bmi_ideal_weight)
            binding.txvResult.setTextColor(ContextCompat.getColor(this, R.color.green))
        } else {
            binding.txvResult.setText(R.string.bmi_above_weight)
            binding.txvResult.setTextColor(ContextCompat.getColor(this, R.color.red))
        }
    }

    private fun setupListeners() {
        binding.btnReturnActivity.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity( intent )
            finish()
        }
        binding.btnOpenFragment.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, EvenOrOddFragment()) // Substituir R.id.fragment_container pelo ID do contêiner do fragmento
                .commit()
        }
    }
}