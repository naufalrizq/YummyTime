package org.d3ifcool.yummytime.views

import org.d3ifcool.yummytime.data.local.Meal

interface CategoryView {
    fun setMeal(meals: ArrayList<Meal>)
    fun onErrorLoading(message: String?)
}