package app.myfood.com

import android.graphics.drawable.GradientDrawable
import android.view.ViewGroup
import app.myfood.com.databinding.BannerItemBinding
import co.tiagoaguiar.atway.ui.adapter.ATViewHolder
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.lang.Exception

class BannerView(viewGroup: ViewGroup) : ATViewHolder<Banner, BannerItemBinding>(
    BannerItemBinding::inflate,
    viewGroup
) {
    override fun bind(item: Banner) {
        Picasso.get()
            .load(item.bannerUrl)
            .into(binding.imgBanner)
    }

}