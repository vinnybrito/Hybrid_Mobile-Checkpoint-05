package com.vinicius.checkpoint05_hybrid_mobile.ui.calculateimc

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.vinicius.checkpoint05_hybrid_mobile.MainActivity
import com.vinicius.checkpoint05_hybrid_mobile.databinding.ActivityBmiResultBinding

class ResultBmiActivity: AppCompatActivity() {
    private lateinit var binding: ActivityBmiResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBmiResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras
        if (bundle != null) {
            val weight = bundle.getDouble("weight")
            val height = bundle.getDouble("height")

            binding.txvWeightInformation.text = "Peso informado $weight kg"
            binding.txvHeightInformation.text = "Altura informada $height m"

            val bmi = weight / (height * height)

            val result = if( bmi < 20.0 ) { "Abaixo do Peso" }
                         else if( bmi < 25.0 ) { "Peso Ideal" }
                         else { "Obeso" }

            binding.txvResult.text = result
        }

        binding.btnReturnActivity.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity( intent )
            finish()
        }

    }
}