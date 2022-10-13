package com.example.hammersystemspizza.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hammersystemspizza.data.ContentData
import com.example.hammersystemspizza.databinding.ActivityMainBinding
import com.example.hammersystemspizza.data.entities.Category
import com.example.hammersystemspizza.data.entities.Item
import com.example.hammersystemspizza.presentation.adapters.CategoriesAdapter

class MainActivity : AppCompatActivity() {


    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val contentData = ContentData.getData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initRV()
        initTabLayout()
    }

    private fun initRV() {
        binding.contentInclude.rvContent.adapter = CategoriesAdapter(contentData)

    }

    private fun initTabLayout() {
        for (category in contentData) {
            binding.contentInclude.tabLayoutMenu.addTab(
                binding.contentInclude.tabLayoutMenu.newTab().setText(category.name)
            )
        }
    }
}