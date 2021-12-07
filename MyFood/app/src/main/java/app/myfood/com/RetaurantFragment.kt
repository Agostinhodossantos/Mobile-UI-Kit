package app.myfood.com

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
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
            Banner(1, "https://static-images.ifood.com.br/image/upload/t_high/discoveries/itensBasicosNOV21Principal_zE1X.png"),
            Banner(2, "https://static-images.ifood.com.br/image/upload/t_high/discoveries/Bebidas40offPrincipal_cljA.png"),
            Banner(3, "https://static-images.ifood.com.br/image/upload/t_high/discoveries/MerceariaeMatinaisPrincipal_mfDO.png"),
        )



        binding = FragmentRestaurantBinding.bind(view)


        binding?.let {

            it.rvCategory.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            it.rvCategory.adapter = categoryAdapter

            filtes.forEach { filter ->
                it.chipGroupFilter.addView(
                    filter.toChip(requireContext())
                )
            }
        }
    }
}