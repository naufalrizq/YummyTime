package org.d3ifcool.yummytime.utils.api

import org.d3ifcool.yummytime.data.model.Categories
import org.d3ifcool.yummytime.data.model.Meals
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("filter.php?a=Italian")
    fun getMeal(): Call<Meals>

    @GET("categories.php")
    fun getCategories(): Call<Categories>

    @GET("filter.php")
    fun getMealByCategory(@Query("c") categoryName: String): Call<Meals>

    @GET("search.php")
    fun getMealByName(@Query("s") mealName: String): Call<Meals>
}