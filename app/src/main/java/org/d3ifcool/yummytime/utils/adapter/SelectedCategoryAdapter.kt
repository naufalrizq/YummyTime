package org.d3ifcool.yummytime.utils.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.d3ifcool.yummytime.data.local.Meal
import org.d3ifcool.yummytime.databinding.ItemSelectedCategoryBinding
import org.d3ifcool.yummytime.views.details.DetailActivity

class SelectedCategoryAdapter(private val list: List<Meal>) :
    RecyclerView.Adapter<SelectedCategoryAdapter.SelectedCategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectedCategoryViewHolder =
        SelectedCategoryViewHolder(
           ItemSelectedCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: SelectedCategoryViewHolder, position: Int) = with(holder) {
        bind(list[position])
        binding.root.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailActivity::class.java).apply {
                putExtra(DetailActivity.EXTRA_DETAIL, list[position].strMeal)
            }
            binding.root.context.startActivity(intent)
        }
    }

    inner class SelectedCategoryViewHolder(val binding: ItemSelectedCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(meal: Meal) {
            with(itemView) {
                Glide.with(context)
                    .load(meal.strMealThumb)
                    .into(binding.ivSelectedCatThumb)

                binding.tvSelectedCatName.text = meal.strMeal
            }
        }
    }
}
