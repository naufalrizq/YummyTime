package org.d3ifcool.yummytime.views.category

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import org.d3ifcool.yummytime.MainActivity
import org.d3ifcool.yummytime.data.local.Category
import org.d3ifcool.yummytime.databinding.ActivityCategoryBinding
import org.d3ifcool.yummytime.utils.adapter.CategoryPagerAdapter

@Suppress("Unchecked_cast")
class CategoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCategoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initActionBar()
        buildPager()
    }

    private fun buildPager() {
        val categories = intent?.getSerializableExtra(MainActivity.EXTRA_CATEGORY) as List<Category>
        val position = intent.getIntExtra(MainActivity.EXTRA_POSITION, 0)

        val adapter = CategoryPagerAdapter(supportFragmentManager, categories)

        binding.mainPager.adapter = adapter
        binding.tabs.setupWithViewPager(binding.mainPager)
        binding.mainPager.setCurrentItem(position, true)
    }

    private fun initActionBar() {
        setSupportActionBar(binding.mToolbar)
        if (supportActionBar != null) supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return true
    }
}