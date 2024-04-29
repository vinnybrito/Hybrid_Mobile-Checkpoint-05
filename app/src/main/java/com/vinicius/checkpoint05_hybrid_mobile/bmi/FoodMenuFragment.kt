package com.vinicius.checkpoint05_hybrid_mobile.bmi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.vinicius.checkpoint05_hybrid_mobile.R
import com.vinicius.checkpoint05_hybrid_mobile.databinding.FragmentFoodMenuBinding

class FoodMenuFragment : Fragment() {

    private lateinit var binding: FragmentFoodMenuBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFoodMenuBinding.inflate(inflater, container, false)
        return binding.root
    }



}