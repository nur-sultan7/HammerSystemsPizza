package com.example.hammersystemspizza.presentation

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.ahmadhamwi.tabsync.TabbedListMediator
import com.example.hammersystemspizza.R
import com.example.hammersystemspizza.databinding.ActivityMainBinding
import com.example.hammersystemspizza.domain.entities.CategoryName
import com.example.hammersystemspizza.presentation.adapters.CategoriesAdapter

class MainActivity : AppCompatActivity() {


    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val viewModel: PizzasViewModel by lazy {
        ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory(application)
        )[PizzasViewModel::class.java]
    }

    private val adapter by lazy {
        CategoriesAdapter()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(binding.toolbar)
        setContentView(binding.root)
        initRV()
        viewModel.getPizzasData().observe(this) {
            adapter.setListOfCategories(viewModel.putItemsInCategory(CategoryName.Pizza.name, it))
        }
        initTabLayout()
        initMediator()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    private fun initRV() {
        binding.contentScrolling.rvContent.adapter = adapter
    }

    private fun initMediator() {
        with(binding) {
            TabbedListMediator(
                contentScrolling.rvContent,
                contentScrolling.tabLayoutMenu,
                viewModel.categoriesItems.indices.toList(),
                true
            ).attach()
        }
    }

    private fun initTabLayout() {
        for (category in CategoryName.values()) {
            binding.contentScrolling.tabLayoutMenu.addTab(
                binding.contentScrolling.tabLayoutMenu.newTab().setText(category.name)
            )
        }
    }
}