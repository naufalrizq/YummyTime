package org.d3ifcool.yummytime.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import org.d3ifcool.yummytime.data.local.Meal

data class Meals(
    @SerializedName("meals")
    @Expose
    val meals: ArrayList<Meal>
)