package com.example.hammersystemspizza.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import com.ahmadhamwi.tabsync.TabbedListMediator
import com.example.hammersystemspizza.R
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
        setSupportActionBar(binding.toolbar)
        setContentView(binding.root)
        initRV()
        initTabLayout()
        initMediator()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    private fun initRV() {
        binding.contentScrolling.rvContent.adapter = CategoriesAdapter(contentData)
    }

    private fun initMediator() {
        with(binding) {
            TabbedListMediator(
                contentScrolling.rvContent,
                contentScrolling.tabLayoutMenu,
                contentData.indices.toList(),
                true
            ).attach()
        }
    }

    private fun initTabLayout() {
        for (category in contentData) {
            binding.contentScrolling.tabLayoutMenu.addTab(
                binding.contentScrolling.tabLayoutMenu.newTab().setText(category.name)
            )
        }
    }
}