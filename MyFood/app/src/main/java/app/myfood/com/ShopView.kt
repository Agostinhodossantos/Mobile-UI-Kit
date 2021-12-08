package app.myfood.com

import android.graphics.drawable.GradientDrawable
import android.view.ViewGroup
import app.myfood.com.databinding.BannerItemBinding
import app.myfood.com.databinding.ShopItemBinding
import co.tiagoaguiar.atway.ui.adapter.ATViewHolder
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.lang.Exception

class ShopView(viewGroup: ViewGroup) : ATViewHolder<Shop, ShopItemBinding>(
    ShopItemBinding::inflate,
    viewGroup
) {

    override fun bind(item: Shop) {
        Picasso.get()
            .load(item.bannerUrl)
            .into(binding.imgShop)

        binding.txtShop.text = item.text
    }

}