package org.d3ifcool.yummytime.views.details

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import org.d3ifcool.yummytime.R
import org.d3ifcool.yummytime.data.local.Meal
import org.d3ifcool.yummytime.databinding.ActivityDetailBinding
import org.d3ifcool.yummytime.utils.api.ApiUtils
import org.d3ifcool.yummytime.utils.presenter.DetailPresenter
import org.d3ifcool.yummytime.views.DetailView

class DetailActivity : AppCompatActivity(), DetailView {
    private lateinit var binding: ActivityDetailBinding
    private lateinit var detailPresenter: DetailPresenter

    companion object {
        const val EXTRA_DETAIL = "extra_detail"
    }

    private fun initActionbar() {
        setSupportActionBar(binding.toolbar)

        binding.collapsingToolbar.apply {
            setContentScrimColor(
                ContextCompat.getColor(
                    this@DetailActivity,
                    R.color.colorWhite
                )
            )
            setCollapsedTitleTextColor(
                ContextCompat.getColor(
                    this@DetailActivity,
                    R.color.colorPrimary
                )
            )
            setExpandedTitleColor(
                ContextCompat.getColor(
                    this@DetailActivity,
                    R.color.colorWhite
                )
            )
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
    
    private fun buildIngredients(meals: Meal) {
        with(binding) {
            if (meals.strIngredient1.isNotEmpty()) ingredient.append("\n \u2022 ${meals.strIngredient1}")
            if (meals.strIngredient2.isNotEmpty()) ingredient.append("\n \u2022 ${meals.strIngredient2}")
            if (meals.strIngredient3.isNotEmpty()) ingredient.append("\n \u2022 ${meals.strIngredient3}")
            if (meals.strIngredient4.isNotEmpty()) ingredient.append("\n \u2022 ${meals.strIngredient4}")
            if (meals.strIngredient5.isNotEmpty()) ingredient.append("\n \u2022 ${meals.strIngredient5}")
            if (meals.strIngredient6.isNotEmpty()) ingredient.append("\n \u2022 ${meals.strIngredient6}")
            if (meals.strIngredient7.isNotEmpty()) ingredient.append("\n \u2022 ${meals.strIngredient7}")
            if (meals.strIngredient8.isNotEmpty()) ingredient.append("\n \u2022 ${meals.strIngredient8}")
            if (meals.strIngredient9.isNotEmpty()) ingredient.append("\n \u2022 ${meals.strIngredient9}")
            if (meals.strIngredient10.isNotEmpty()) ingredient.append("\n \u2022 ${meals.strIngredient10}")
            if (meals.strIngredient11.isNotEmpty()) ingredient.append("\n \u2022 ${meals.strIngredient11}")
            if (meals.strIngredient12.isNotEmpty()) ingredient.append("\n \u2022 ${meals.strIngredient12}")
            if (meals.strIngredient13.isNotEmpty()) ingredient.append("\n \u2022 ${meals.strIngredient13}")
            if (meals.strIngredient14.isNotEmpty()) ingredient.append("\n \u2022 ${meals.strIngredient14}")
            if (meals.strIngredient15.isNotEmpty()) ingredient.append("\n \u2022 ${meals.strIngredient15}")
            if (meals.strIngredient16.isNotEmpty()) ingredient.append("\n \u2022 ${meals.strIngredient16}")
            if (meals.strIngredient17.isNotEmpty()) ingredient.append("\n \u2022 ${meals.strIngredient17}")
            if (meals.strIngredient18.isNotEmpty()) ingredient.append("\n \u2022 ${meals.strIngredient18}")
            if (meals.strIngredient19.isNotEmpty()) ingredient.append("\n \u2022 ${meals.strIngredient19}")
            if (meals.strIngredient20.isNotEmpty()) ingredient.append("\n \u2022 ${meals.strIngredient20}")

            if (meals.strIngredient1.isNotEmpty() && !Character.isWhitespace(meals.strMeasure1[0]))
                tvMeasureDetail.append("\n \u2022 ${meals.strMeasure1}")
            if (meals.strIngredient2.isNotEmpty() && !Character.isWhitespace(meals.strMeasure2[0]))
                tvMeasureDetail.append("\n \u2022 ${meals.strMeasure2}")
            if (meals.strIngredient3.isNotEmpty() && !Character.isWhitespace(meals.strMeasure3[0]))
                tvMeasureDetail.append("\n \u2022 ${meals.strMeasure3}")
            if (meals.strIngredient4.isNotEmpty() && !Character.isWhitespace(meals.strMeasure4[0]))
                tvMeasureDetail.append("\n \u2022 ${meals.strMeasure4}")
            if (meals.strIngredient5.isNotEmpty() && !Character.isWhitespace(meals.strMeasure5[0]))
                tvMeasureDetail.append("\n \u2022 ${meals.strMeasure5}")
            if (meals.strIngredient6.isNotEmpty() && !Character.isWhitespace(meals.strMeasure6[0]))
                tvMeasureDetail.append("\n \u2022 ${meals.strMeasure6}")
            if (meals.strIngredient7.isNotEmpty() && !Character.isWhitespace(meals.strMeasure7[0]))
                tvMeasureDetail.append("\n \u2022 ${meals.strMeasure7}")
            if (meals.strIngredient8.isNotEmpty() && !Character.isWhitespace(meals.strMeasure8[0]))
                tvMeasureDetail.append("\n \u2022 ${meals.strMeasure8}")
            if (meals.strIngredient9.isNotEmpty() && !Character.isWhitespace(meals.strMeasure9[0]))
                tvMeasureDetail.append("\n \u2022 ${meals.strMeasure9}")
            if (meals.strIngredient10.isNotEmpty() && !Character.isWhitespace(meals.strMeasure10[0]))
                tvMeasureDetail.append("\n \u2022 ${meals.strMeasure10}")
            if (meals.strIngredient11.isNotEmpty() && !Character.isWhitespace(meals.strMeasure11[0]))
                tvMeasureDetail.append("\n \u2022 ${meals.strMeasure11}")
            if (meals.strIngredient12.isNotEmpty() && !Character.isWhitespace(meals.strMeasure12[0]))
                tvMeasureDetail.append("\n \u2022 ${meals.strMeasure12}")
            if (meals.strIngredient13.isNotEmpty() && !Character.isWhitespace(meals.strMeasure13[0]))
                tvMeasureDetail.append("\n \u2022 ${meals.strMeasure13}")
            if (meals.strIngredient14.isNotEmpty() && !Character.isWhitespace(meals.strMeasure14[0]))
                tvMeasureDetail.append("\n \u2022 ${meals.strMeasure14}")
            if (meals.strIngredient15.isNotEmpty() && !Character.isWhitespace(meals.strMeasure15[0]))
                tvMeasureDetail.append("\n \u2022 ${meals.strMeasure15}")
            if (meals.strIngredient16.isNotEmpty() && !Character.isWhitespace(meals.strMeasure16[0]))
                tvMeasureDetail.append("\n \u2022 ${meals.strMeasure16}")
            if (meals.strIngredient17.isNotEmpty() && !Character.isWhitespace(meals.strMeasure17[0]))
                tvMeasureDetail.append("\n \u2022 ${meals.strMeasure17}")
            if (meals.strIngredient18.isNotEmpty() && !Character.isWhitespace(meals.strMeasure18[0]))
                tvMeasureDetail.append("\n \u2022 ${meals.strMeasure18}")
            if (meals.strIngredient19.isNotEmpty() && !Character.isWhitespace(meals.strMeasure19[0]))
                tvMeasureDetail.append("\n \u2022 ${meals.strMeasure19}")
            if (meals.strIngredient20.isNotEmpty() && !Character.isWhitespace(meals.strMeasure20[0]))
                tvMeasureDetail.append("\n \u2022 ${meals.strMeasure20}")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initActionbar()

        if (intent.hasExtra(EXTRA_DETAIL)) {
            detailPresenter = DetailPresenter(this)

            val detailExtra = intent.getStringExtra(EXTRA_DETAIL)!!
            detailPresenter.getMealByName(detailExtra)
        }
    }

    override fun setMeal(meals: Meal) {
        with(binding) {
            collapsingToolbar.title = meals.strMeal

            tvDotCatDetail.text = meals.strCategory
            tvDotCountryDetail.text = meals.strArea

            // Set the meal instructions
            tvDotInstructionDetail.apply {
                text = meals.strInstructions
                    .replace("\r\n\r\n", "\n\n")
                    .replace("\r\n", "\n\n")
            }

            initActionbar()
            buildIngredients(meals)

            btnYoutube.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW)
                startActivity(intent.setData(Uri.parse(meals.strYoutube)))
            }

            btnYoutube.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW)
                startActivity(intent.setData(Uri.parse(meals.strSource)))
            }

            binding.pbLoadingDetail.visibility = View.GONE
        }

        Glide.with(this)
            .load(meals.strMealThumb)
            .into(binding.ivMealThumbDetail)
    }

    override fun onErrorLoading(message: String?) {
        ApiUtils().showDialog(this, "Failed to fetch data!", message!!)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return true
    }
}