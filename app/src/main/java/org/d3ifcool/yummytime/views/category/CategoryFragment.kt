package org.d3ifcool.yummytime.views.category

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import org.d3ifcool.yummytime.data.local.Meal
import org.d3ifcool.yummytime.databinding.FragmentCategoryBinding
import org.d3ifcool.yummytime.utils.adapter.CategoryPagerAdapter
import org.d3ifcool.yummytime.utils.adapter.SelectedCategoryAdapter
import org.d3ifcool.yummytime.utils.api.ApiUtils
import org.d3ifcool.yummytime.utils.presenter.CategoryPresenter
import org.d3ifcool.yummytime.views.CategoryView

class CategoryFragment : Fragment(), CategoryView {
    private lateinit var binding: FragmentCategoryBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCategoryBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (arguments != null) {
            binding.tvDetailCat.apply {
                text = requireArguments()
                    .getString(CategoryPagerAdapter.EXTRA_DATA_DESC)
                    ?.replace("\r\n\r\n", "\n\n")
                    ?.replace("\r\n", "\n\n")

                movementMethod = ScrollingMovementMethod()
            }

            Glide.with(requireActivity())
                .load(arguments?.getString(CategoryPagerAdapter.EXTRA_DATA_IMG))
                .into(binding.ivBgCat)

            val categoryPresenter = CategoryPresenter(this)
            categoryPresenter.getMealSelectedCategory(
                requireArguments().getString(CategoryPagerAdapter.EXTRA_DATA_CATEGORY).toString()
            )
        }
    }

    override fun setMeal(meals: ArrayList<Meal>) {
        val selectedCategoryAdapter = SelectedCategoryAdapter(meals)

        binding.rvSelectedCat.apply {
            adapter = selectedCategoryAdapter
            layoutManager = GridLayoutManager(requireActivity(), 2)
        }

        binding.pbLoadingCat.visibility = View.GONE
    }

    override fun onErrorLoading(message: String?) {
        ApiUtils().showDialog(requireActivity(), "Failed to fetch data!", message!!)
    }
}