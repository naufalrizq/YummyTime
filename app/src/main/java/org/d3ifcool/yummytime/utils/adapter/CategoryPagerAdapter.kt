package org.d3ifcool.yummytime.utils.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import org.d3ifcool.yummytime.data.local.Category
import org.d3ifcool.yummytime.views.category.CategoryFragment

class CategoryPagerAdapter(fm: FragmentManager, private val categories: List<Category>) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    companion object {
        const val EXTRA_DATA_DESC = "extra_desc"
        const val EXTRA_DATA_CATEGORY = "extra_cat"
        const val EXTRA_DATA_IMG = "extra_img"
    }

    override fun getItem(position: Int): Fragment {
        val fragment = CategoryFragment()
        val bundle = Bundle()

        bundle.putString(EXTRA_DATA_DESC, categories[position].strCategoryDescription)
        bundle.putString(EXTRA_DATA_CATEGORY, categories[position].strCategory)
        bundle.putString(EXTRA_DATA_IMG, categories[position].strCategoryThumb)

        fragment.arguments = bundle
        return fragment
    }

    override fun getCount(): Int = categories.size

    override fun getPageTitle(position: Int): CharSequence = categories[position].strCategory
}