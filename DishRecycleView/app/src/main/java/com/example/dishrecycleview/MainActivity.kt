package com.example.dishrecycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dishrecycleview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        initCategoryAdapter()
    }

    private fun initCategoryAdapter(){
        val categories= arrayListOf("全部","素菜","荤菜","汤类","水果")
        binding.layoutCategory?.rcyCategory?.adapter=CategoryAdapter(categories){

        }
        binding.layoutCategory?.rcyCategory?.layoutManager=LinearLayoutManager(this)

        val dishes= arrayListOf("番茄炒蛋","番茄炒蛋","番茄炒蛋","番茄炒蛋","番茄炒蛋",
            "番茄炒蛋","番茄炒蛋","番茄炒蛋","番茄炒蛋","番茄炒蛋",
            "番茄炒蛋","番茄炒蛋","番茄炒蛋","番茄炒蛋","番茄炒蛋",
            "番茄炒蛋","番茄炒蛋","番茄炒蛋","番茄炒蛋","番茄炒蛋")
        binding.rcyDish?.adapter=DishAdapter(dishes){

        }
        val spacing = resources.getDimensionPixelSize(R.dimen.grid_spacing_16dp)
        val includeEdge = true
        binding.rcyDish?.layoutManager=GridLayoutManager(this,5)
        binding.rcyDish?.addItemDecoration(GridSpacingItemDecoration(5,spacing,true))
    }
}