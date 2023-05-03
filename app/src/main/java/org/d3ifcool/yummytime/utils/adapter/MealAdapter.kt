package org.d3ifcool.yummytime.utils.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.d3ifcool.yummytime.data.local.Meal
import org.d3ifcool.yummytime.databinding.ItemPagerBinding
import org.d3ifcool.yummytime.views.details.DetailActivity

class MealAdapter(private val list: ArrayList<Meal>) :
    RecyclerView.Adapter<MealAdapter.MealViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealViewHolder =
        MealViewHolder(
            ItemPagerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: MealViewHolder, position: Int) = with(holder) {
        bind(list[position])
        binding.root.setOnClickListener {
            val intent = Intent(binding.root.context, DetailActivity::class.java).apply {
                putExtra(DetailActivity.EXTRA_DETAIL, list[position].strMeal)
            }

            binding.root.context.startActivity(intent)
        }
    }

    inner class MealViewHolder(val binding: ItemPagerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(meal: Meal) {
            with(itemView) {
                with(binding) {
                    Glide.with(context)
                        .load(meal.strMealThumb)
                        .into(ivMealThumb)

                    tvMealName.text = meal.strMeal
                }
            }
        }
    }
}