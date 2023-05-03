package org.d3ifcool.yummytime.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import org.d3ifcool.yummytime.data.local.Category


data class Categories(
    @SerializedName("categories")
    @Expose
    val categories: ArrayList<Category>
)