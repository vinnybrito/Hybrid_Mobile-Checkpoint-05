package com.vinicius.checkpoint05_hybrid_mobile.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vinicius.appderestaurante.model.Food
import com.vinicius.checkpoint05_hybrid_mobile.databinding.FoodItemBinding

class FoodAdapter(
    private val context: Context,
    private val foodList: MutableList<Food>
) : RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val listItem = FoodItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return FoodViewHolder(listItem)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.imgFood.setBackgroundResource(foodList[position].imgFood!!)
        holder.txtFoodName.text = foodList[position].foodName
        holder.txtFoodDescription.text = foodList[position].foodDescription
        holder.txtFoodPrice.text = foodList[position].price
    }

    override fun getItemCount() = foodList.size

    inner class FoodViewHolder(binding: FoodItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val imgFood = binding.imgFoodItem
        val txtFoodName = binding.txtTitleFoodItem
        val txtFoodDescription = binding.txtDescriptionFoodItem
        val txtFoodPrice = binding.txtPriceFoodItem
    }

}