package app.myfood.com

import android.view.ViewGroup
import app.myfood.com.databinding.CategoryItemBinding
import co.tiagoaguiar.atway.ui.adapter.ATViewHolder

class CategoryView(viewGroup: ViewGroup) : ATViewHolder<Category, CategoryItemBinding>(
    CategoryItemBinding::inflate,
    viewGroup
) {
    override fun bind(item: Category) {
        binding.txtCategory.text = item.name
    }

}