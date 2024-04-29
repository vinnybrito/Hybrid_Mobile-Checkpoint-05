package com.vinicius.checkpoint05_hybrid_mobile.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.vinicius.appderestaurante.model.Food
import com.vinicius.checkpoint05_hybrid_mobile.R
import com.vinicius.checkpoint05_hybrid_mobile.adapter.FoodAdapter
import com.vinicius.checkpoint05_hybrid_mobile.databinding.FragmentFoodMenuBinding

class FoodMenuFragment : Fragment() {

    private lateinit var binding: FragmentFoodMenuBinding
    private lateinit var foodAdapter: FoodAdapter
    private val foodList: MutableList<Food> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFoodMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerViewFood: RecyclerView = binding.rcvActivityMain
        recyclerViewFood.setHasFixedSize(true)
        foodAdapter = FoodAdapter(requireContext(), foodList)
        recyclerViewFood.adapter = foodAdapter

        getFood()
    }

    private fun getFood() {
        val food1 = Food (
            imgFood = R.drawable.food1,
            foodName = "Combo da Casa",
            foodDescription = "Batata Frita com Camarão, limão e refrigerante",
            price = "R$45.90"
        )
        foodList.add(food1)

        val food2 = Food (
            imgFood = R.drawable.food5,
            foodName = "A moda do Chefe",
            foodDescription = "Batata Frita com Camarão, limão e refrigerante, cebola, arroz",
            price = "R$69.90"
        )
        foodList.add(food2)

        val food3 = Food (
            imgFood = R.drawable.food3,
            foodName = "Combo da Casa",
            foodDescription = "Batata Frita com Camarão, limão e refrigerante",
            price = "R$20.90"
        )
        foodList.add(food3)

        val food4 = Food (
            imgFood = R.drawable.food4,
            foodName = "Combo da Casa",
            foodDescription = "Batata Frita com Camarão, limão e refrigerante",
            price = "R$45.90"
        )
        foodList.add(food4)

        val food5 = Food (
            imgFood = R.drawable.food5,
            foodName = "Combo da Casa",
            foodDescription = "Batata Frita com Camarão, limão e refrigerante",
            price = "R$45.90"
        )
        foodList.add(food5)
    }

}