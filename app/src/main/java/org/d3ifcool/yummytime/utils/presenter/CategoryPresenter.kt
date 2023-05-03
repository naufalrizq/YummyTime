package org.d3ifcool.yummytime.utils.presenter

import android.util.Log
import org.d3ifcool.yummytime.data.model.Meals
import org.d3ifcool.yummytime.utils.api.ApiUtils
import org.d3ifcool.yummytime.views.CategoryView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoryPresenter(private val view: CategoryView) {
    fun getMealSelectedCategory(categoryName: String) {
        val call = ApiUtils().getAPI().getMealByCategory(categoryName)

        call.enqueue(object : Callback<Meals> {
            override fun onResponse(call: Call<Meals>, response: Response<Meals>) {
                if (response.isSuccessful && response.body() != null) {
                    view.setMeal(response.body()!!.meals)
                } else view.onErrorLoading(response.message())
            }

            override fun onFailure(call: Call<Meals>, t: Throwable) {
                view.onErrorLoading(t.localizedMessage)

                Log.i(
                    "CategoryPresenter.meals",
                    "Failed! ${t.message} --- ${t.printStackTrace()}"
                )
            }
        })
    }
}