package app.myfood.com

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import app.myfood.com.databinding.FragmentRestaurantBinding

class RetaurantFragment: Fragment(R.layout.fragment_restaurant) {

    private var binding: FragmentRestaurantBinding? = null

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

        binding = FragmentRestaurantBinding.bind(view)

        binding?.let {
            filtes.forEach { filter ->
                it.chipGroupFilter.addView(
                    filter.toChip(requireContext())
                )
            }
        }
    }
}