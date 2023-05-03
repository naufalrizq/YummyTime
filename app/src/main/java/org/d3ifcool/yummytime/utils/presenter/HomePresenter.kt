package org.d3ifcool.yummytime.utils.presenter

import android.util.Log
import org.d3ifcool.yummytime.data.model.Categories
import org.d3ifcool.yummytime.data.model.Meals
import org.d3ifcool.yummytime.utils.api.ApiUtils
import org.d3ifcool.yummytime.views.HomeView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomePresenter(private val view: HomeView) {
    fun getMeals() {
        val callMeals: Call<Meals> = ApiUtils().getAPI().getMeal()

        callMeals.enqueue(object : Callback<Meals> {
            override fun onResponse(call: Call<Meals>, response: Response<Meals>) {
                if (response.isSuccessful && response.body() != null)
                    view.setMeals(response.body()!!.meals)
                else
                    view.onErrorLoading(response.message())
            }

            override fun onFailure(call: Call<Meals>, t: Throwable) {
                view.onErrorLoading(t.localizedMessage)

                Log.i(
                    "HomePresenter.meals",
                    "Failed! ${t.message} --- ${t.printStackTrace()}"
                )
            }
        })
    }

    fun getCategories() {
        val callCategories: Call<Categories> = ApiUtils().getAPI().getCategories()

        callCategories.enqueue(object : Callback<Categories> {
            override fun onResponse(call: Call<Categories>, response: Response<Categories>) {
                if (response.isSuccessful && response.body() != null)
                    view.setCategories(response.body()!!.categories)
                else
                    view.onErrorLoading(response.message())
            }

            override fun onFailure(call: Call<Categories>, t: Throwable) {
                view.onErrorLoading(t.localizedMessage)

                Log.i(
                    "HomePresenter.categories",
                    "Failed! ${t.message} --- ${t.printStackTrace()}"
                )
            }
        })
    }
}