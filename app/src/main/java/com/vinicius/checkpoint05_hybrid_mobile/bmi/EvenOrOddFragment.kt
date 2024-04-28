package com.vinicius.checkpoint05_hybrid_mobile.bmi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vinicius.checkpoint05_hybrid_mobile.R
import com.vinicius.checkpoint05_hybrid_mobile.databinding.FragmentEvenOrOddBinding

class EvenOrOddFragment : Fragment() {

    private lateinit var binding: FragmentEvenOrOddBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEvenOrOddBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()
    }

    private fun setupListeners() {
        binding.btnCloseFragment.setOnClickListener {
            val fragmentManager = requireActivity().supportFragmentManager
            fragmentManager.beginTransaction().remove(this@EvenOrOddFragment).commit()
        }
    }

}