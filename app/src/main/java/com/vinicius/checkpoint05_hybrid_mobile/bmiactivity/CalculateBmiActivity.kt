package com.vinicius.checkpoint05_hybrid_mobile.bmiactivity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.vinicius.checkpoint05_hybrid_mobile.R
import com.vinicius.checkpoint05_hybrid_mobile.databinding.ActivityBmiCalculateBinding

class CalculateBmiActivity: AppCompatActivity() {

    private lateinit var binding: ActivityBmiCalculateBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBmiCalculateBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupListener()
    }

    private fun setupListener() {
        binding.btnCalculateBmi.setOnClickListener {
            val intent = Intent(this, BmiResultActivity::class.java)
            val weight = binding.editWeight.text.toString()
            val height = binding.editHeight.text.toString()

            if (weight.isNotEmpty() && height.isNotEmpty()) {
                intent.putExtra("weight", weight.toDouble())
                intent.putExtra("height", height.toDouble())
                startActivity( intent )
            } else {
                binding.txtInputLayoutWeight.boxStrokeColor = ContextCompat
                    .getColor(this, R.color.morbid_obesity)
                binding.txtInputLayoutHeight.boxStrokeColor = ContextCompat
                    .getColor(this, R.color.morbid_obesity)
                Toast.makeText(this, "Preencha Todos os Campos", Toast.LENGTH_LONG).show()
            }
        }
        binding.btnReturnActivity.setOnClickListener {
            finish()
        }
    }

}