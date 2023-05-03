package org.d3ifcool.yummytime.utils.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.d3ifcool.yummytime.MainActivity
import org.d3ifcool.yummytime.data.local.Category
import org.d3ifcool.yummytime.databinding.ItemCategoryBinding
import org.d3ifcool.yummytime.views.category.CategoryActivity

class CategoryAdapter(private val list: ArrayList<Category>) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder =
        CategoryViewHolder(
            ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) = with(holder) {
        bind(list[position])
        binding.root.setOnClickListener {
            val intent = Intent(holder.itemView.context, CategoryActivity::class.java).apply {
                putExtra(MainActivity.EXTRA_CATEGORY, list)
                putExtra(MainActivity.EXTRA_POSITION, position)
            }

            holder.binding.root.context.startActivity(intent)
        }
    }

    inner class CategoryViewHolder(val binding: ItemCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(category: Category) {
            with(itemView) {
                with(binding) {
                    Glide.with(context)
                        .load(category.strCategoryThumb)
                        .into(ivCategoryThumb)

                    tvCategoryName.text = category.strCategory
                }
            }
        }
    }
}