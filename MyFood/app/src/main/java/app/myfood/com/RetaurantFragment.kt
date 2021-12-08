package app.myfood.com

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import app.myfood.com.databinding.FragmentRestaurantBinding
import co.tiagoaguiar.atway.ui.adapter.ATAdapter

class RetaurantFragment: Fragment(R.layout.fragment_restaurant) {

    private var binding: FragmentRestaurantBinding? = null

    private var categoryAdapter = ATAdapter({ CategoryView(it) })
    private var bannerAdapter = ATAdapter({ BannerView(it) })

    private var filtes = arrayOf(
        FilterItem(1,"Order", closeIcon = R.drawable.ic_baseline_keyboard_arrow_down_24),
        FilterItem(2,"Para retirar", icon = R.drawable.ic_baseline_directions_walk_24),
        FilterItem(3,"Entrega"),
        FilterItem(4,"Vale refeicao", closeIcon = R.drawable.ic_baseline_keyboard_arrow_down_24),
        FilterItem(5,"Distancia"),
        FilterItem(6,"Entrega parceiria"),
        FilterItem(7,"Super Restaurantes"),
        FilterItem(8,"Filtros", R.drawable.ic_baseline_filter_list_24),
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        categoryAdapter.items = arrayListOf(
            Category(1, "https://testskitchen.com/wp-content/uploads/2021/04/Fast-Food.jpg", "Mercado", 0xFFB6D048),
            Category(2, "https://testskitchen.com/wp-content/uploads/2021/04/Fast-Food.jpg", "Restaurante", 0xFFE91D2D),
            Category(3, "https://static.clubedaanamariabraga.com.br/wp-content/uploads/2019/11/drink-lagoa-azul-1024x576.jpg", "Bebidas", 0xFFF6D553),
            Category(4, "https://blog.deliverymuch.com.br/wp-content/uploads/2020/06/O-que-%C3%A9-fast-food-Conhe%C3%A7a-o-milion%C3%A1rio-mercado-de-comidas-r%C3%A1pidas-750x410.jpg", "Express", 0xFFFF0000),
            Category(5, "https://testskitchen.com/wp-content/uploads/2021/04/Fast-Food.jpg", "Saudável", 0xFFE91D2D),
            Category(6, "https://testskitchen.com/wp-content/uploads/2021/04/Fast-Food.jpg", "Salgados", 0xFF8C60C5),
            )

        bannerAdapter.items = arrayListOf(
            Banner(1, "https://image.freepik.com/free-vector/beef-hamburger-background_1284-12693.jpg"),
            Banner(2, "https://image.freepik.com/free-psd/delicious-burger-food-menu-social-media-banner-template_106176-354.jpg"),
            Banner(3, "https://static-images.ifood.com.br/image/upload/t_high/discoveries/MerceariaeMatinaisPrincipal_mfDO.png"),
        )

        binding = FragmentRestaurantBinding.bind(view)


        binding?.let {

            it.rvCategory.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            it.rvCategory.adapter = categoryAdapter

            it.rvBanner.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            it.rvBanner.adapter = bannerAdapter
            it.rvBanner.addOnScrollListener( object : RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                   if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                       notifyPositionChaged(recyclerView)
                   }
                }
            })


            filtes.forEach { filter ->
                it.chipGroupFilter.addView(
                    filter.toChip(requireContext())
                )
            }

            addDots(it.dots, bannerAdapter.items.size, 0)
        }
    }

    private var position: Int? = RecyclerView.NO_POSITION
    private val snapHelper = LinearSnapHelper()

    private fun notifyPositionChaged(recyclerView: RecyclerView) {
        val layoutManager = recyclerView.layoutManager
        val view = snapHelper.findSnapView(layoutManager)
        val position = if (view == null) RecyclerView.NO_POSITION else layoutManager?.getPosition(view)

        val positionChanged = this.position != position
        if (positionChanged) {
            addDots(binding!!.dots, bannerAdapter.items.size, position ?: 0)
        }
        this.position = position

    }

    private fun addDots(container: LinearLayout, size: Int, position: Int) {
        container.removeAllViews()

        Array(size) {
            val textView = TextView(context).apply {
                text = getString(R.string.dotted)
                textSize = 25f
                setTextColor(
                    if (position == it) ContextCompat.getColor(context, android.R.color.black)
                    else ContextCompat.getColor(context, android.R.color.darker_gray)
                )
            }
            container.addView(textView)
        }

    }
}