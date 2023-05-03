package org.d3ifcool.yummytime.views

import org.d3ifcool.yummytime.data.local.Meal

interface DetailView {
    fun setMeal(meals: Meal)
    fun onErrorLoading(message: String?)
}