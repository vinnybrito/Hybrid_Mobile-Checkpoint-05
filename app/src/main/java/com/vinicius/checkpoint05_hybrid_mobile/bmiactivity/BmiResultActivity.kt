package com.vinicius.checkpoint05_hybrid_mobile.bmiactivity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.vinicius.checkpoint05_hybrid_mobile.R
import com.vinicius.checkpoint05_hybrid_mobile.databinding.ActivityResultBmiBinding
import com.vinicius.checkpoint05_hybrid_mobile.fragment.FoodMenuFragment

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
                String.format("%.1f", weight),
                String.format("%.2f", height)
            )
            calculateBmi(weight, height)
        }
    }

    private fun calculateBmi(weight: Double, height: Double) {
        val bmi = weight / ( height * height )

        if (bmi < 18.5) {
            binding.txvResult.setText(R.string.bmi_under_weight)
            binding.txvResult.setTextColor(ContextCompat.getColor(this, R.color.under_weight))
        } else if (bmi < 24.9) {
            binding.txvResult.setText(R.string.bmi_ideal_weight)
            binding.txvResult.setTextColor(ContextCompat.getColor(this, R.color.ideal_weight))
        } else if(bmi < 29.9) {
            binding.txvResult.setText(R.string.bmi_overweight)
            binding.txvResult.setTextColor(ContextCompat.getColor(this, R.color.overweight))
        } else if(bmi < 34.9) {
            binding.txvResult.setText(R.string.bmi_obesity)
            binding.txvResult.setTextColor(ContextCompat.getColor(this, R.color.obesity))
        } else {
            binding.txvResult.setText(R.string.bmi_morbid_obesity)
            binding.txvResult.setTextColor(ContextCompat.getColor(this, R.color.morbid_obesity))
        }
    }

    private fun setupListeners() {
        binding.btnReturnActivity.setOnClickListener {
            /*
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity( intent )
             */
            finish()
        }
        binding.btnOpenFragment.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fcv_menu_food, FoodMenuFragment())
                .commit()
        }
    }
}