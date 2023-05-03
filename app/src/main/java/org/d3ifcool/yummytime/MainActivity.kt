package org.d3ifcool.yummytime

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import org.d3ifcool.yummytime.data.local.Category
import org.d3ifcool.yummytime.data.local.Meal
import org.d3ifcool.yummytime.databinding.ActivityMainBinding
import org.d3ifcool.yummytime.utils.adapter.CategoryAdapter
import org.d3ifcool.yummytime.utils.adapter.MealAdapter
import org.d3ifcool.yummytime.utils.api.ApiUtils
import org.d3ifcool.yummytime.utils.presenter.HomePresenter
import org.d3ifcool.yummytime.views.HomeView

class MainActivity : AppCompatActivity(), HomeView {
    private lateinit var presenter: HomePresenter
    private lateinit var binding: ActivityMainBinding

    companion object {
        const val EXTRA_CATEGORY = "category"
        const val EXTRA_POSITION = "position"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = HomePresenter(this)

        with(presenter) {
            getMeals()
            getCategories()
        }
    }

    override fun setMeals(meals: ArrayList<Meal>) {
        val mealAdapter = MealAdapter(meals)

        binding.rvHeader.apply {
            adapter = mealAdapter
            layoutManager = LinearLayoutManager(
                this@MainActivity,
                LinearLayoutManager.HORIZONTAL,
                false
            )
        }
    }

    override fun setCategories(categories: ArrayList<Category>) {
        val categoryAdapter = CategoryAdapter(categories)

        binding.rvCategory.apply {
            adapter = categoryAdapter
            layoutManager = GridLayoutManager(
                this@MainActivity,
                2,
                GridLayoutManager.VERTICAL,
                false
            )
            isNestedScrollingEnabled = true
        }
    }

    override fun onErrorLoading(message: String?) {
        ApiUtils().showDialog(this, "Failed to fetch data!", message!!)
    }
}