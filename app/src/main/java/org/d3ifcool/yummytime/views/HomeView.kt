package org.d3ifcool.yummytime.views

import org.d3ifcool.yummytime.data.local.Category
import org.d3ifcool.yummytime.data.local.Meal

interface HomeView {
    fun setMeals(meals: ArrayList<Meal>)
    fun setCategories(categories: ArrayList<Category>)

    fun onErrorLoading(message: String?)
}
