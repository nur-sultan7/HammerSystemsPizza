package com.example.hammersystemspizza.presentation

import android.os.Bundle
import android.view.Menu
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.SpinnerAdapter
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.ahmadhamwi.tabsync.TabbedListMediator
import com.example.hammersystemspizza.R
import com.example.hammersystemspizza.databinding.ActivityMainBinding
import com.example.hammersystemspizza.domain.entities.CategoryName
import com.example.hammersystemspizza.presentation.adapters.CategoriesAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener


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
        supportActionBar?.setDisplayShowTitleEnabled(false)
        setContentView(binding.root)
        initRV()
        viewModel.getPizzasData().observe(this) {
            adapter.setListOfCategories(viewModel.putItemsInCategory(CategoryName.Pizza.name, it))
        }
        initTabLayout()
        initMediator()
        initSpinnerInToolbar()
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
        with(binding.contentScrolling) {
            for (category in CategoryName.values()) {
                tabLayoutMenu.addTab(
                    tabLayoutMenu.newTab()
                )
            }
            for (i in 0 until tabLayoutMenu.tabCount) {
                tabLayoutMenu.getTabAt(i)?.setCustomView(R.layout.tab_item)
                val tabName =
                    tabLayoutMenu
                        .getTabAt(i)?.customView?.findViewById(R.id.tv_tab_item) as TextView
                tabName.text = CategoryName.values()[i].toString()
            }
            tabLayoutMenu.addOnTabSelectedListener(object : OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab?) {
                    val tv = tab?.customView?.findViewById<TextView>(R.id.tv_tab_item)
                    tv?.setBackgroundColor(getColor(R.color.pinky_light))
                    tv?.setTextColor(getColor(R.color.pinky))
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {
                    val tv = tab?.customView?.findViewById<TextView>(R.id.tv_tab_item)
                    tv?.setBackgroundColor(getColor(R.color.white))
                    tv?.setTextColor(getColor(R.color.gray_tab_text))
                }

                override fun onTabReselected(tab: TabLayout.Tab?) {
                    val tv = tab?.customView?.findViewById<TextView>(R.id.tv_tab_item)
                    tv?.setBackgroundColor(getColor(R.color.pinky_light))
                    tv?.setTextColor(getColor(R.color.pinky))
                }
            })
            tabLayoutMenu.selectTab(tabLayoutMenu.getTabAt(0))
        }

    }

    private fun initSpinnerInToolbar() {
        val spinnerAdapter: SpinnerAdapter = ArrayAdapter.createFromResource(
            applicationContext, R.array.spinner_categories, R.layout.spinner_dropdown_item
        )
        val navigationSpinner = Spinner(baseContext)
        navigationSpinner.adapter = spinnerAdapter
        binding.toolbar.addView(navigationSpinner, 0)
    }

}