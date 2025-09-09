package com.example.dishrecycleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dishrecycleview.databinding.ItemDishBinding

class DishAdapter(
    private val dishes:List<String>,
    private val onClick:(String)->Unit
):RecyclerView.Adapter<DishAdapter.DishViewHolder>() {

    private var selectedPosition = -1
    inner class DishViewHolder(val binding: ItemDishBinding):RecyclerView.ViewHolder(binding.root){
        init {
            binding.root.setOnClickListener {
                val position=adapterPosition
                if (position==RecyclerView.NO_POSITION){
                    return@setOnClickListener
                }
                val previous=selectedPosition
                selectedPosition=if (position==selectedPosition){
                    RecyclerView.NO_POSITION
                }else{
                    position
                }
                notifyItemChanged(previous)
                notifyItemChanged(selectedPosition)
            }
        }
        fun bind(isSelected:Boolean){
            val tvDishName=binding.tvDishName
            val imgDish=binding.imgDish
            val imgSelected=binding.imgSelected
            if (isSelected){
                imgSelected.visibility=View.VISIBLE
            }else{
                imgSelected.visibility=View.GONE
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DishViewHolder {
        val binding=ItemDishBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return DishViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dishes.size
    }

    override fun onBindViewHolder(holder: DishViewHolder, position: Int) {
        holder.bind(position==selectedPosition)
    }

}