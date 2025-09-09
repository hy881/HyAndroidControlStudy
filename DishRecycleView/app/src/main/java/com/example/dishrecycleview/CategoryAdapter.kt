package com.example.dishrecycleview

import android.content.res.Resources
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.dishrecycleview.databinding.ItemCategoryBinding

class CategoryAdapter(
    private val categories:List<String>,
    private val onClick:(String)->Unit
) :RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>(){
    private var selectedPosition=0

    inner class CategoryViewHolder(binding:ItemCategoryBinding):RecyclerView.ViewHolder(binding.root){
        val categoryName=binding.tvCategoryName
        val indicator=binding.viewIndicator

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding=ItemCategoryBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CategoryViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.categoryName.text=categories[position]
        val isSelected=position==selectedPosition
        holder.itemView.isSelected=isSelected
        if (isSelected){
            holder.indicator.visibility=View.VISIBLE
            holder.categoryName.setTextColor(
                ContextCompat.getColor(holder.categoryName.context,
                    R.color.tv_category_selected))
        }else{
            holder.indicator.visibility=View.GONE
            holder.categoryName.setTextColor(
                ContextCompat.getColor(holder.categoryName.context,
                    R.color.tv_category_normal))
        }

        holder.itemView.setOnClickListener {
            selectedPosition=position
            notifyDataSetChanged()
            onClick(categories[position])
        }
    }

}