package com.zireddinismayilov.foodsapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.zireddinismayilov.foodsapi.Adapter.foodAdapter
import com.zireddinismayilov.foodsapi.Adapter.foodCategoryAdapter
import com.zireddinismayilov.foodsapi.ViewModel.MainActivityViewModel
import com.zireddinismayilov.foodsapi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.foodRecyclerView.layoutManager = GridLayoutManager(this, 2)

        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
        binding.searchBtn.setOnClickListener {
            if (binding.searchET.text.length <= 1) {
                viewModel.getDataByFirstLetter(binding.searchET.text.toString(), this)
            } else {
                viewModel.getDataByName(binding.searchET.text.toString(), this)
            }
        }

        viewModel.observeResult().observe(this, Observer { it ->
            binding.foodRecyclerView.adapter = foodAdapter(it)
        })
    }

}