package app.myfood.com

import android.content.Context
import android.view.ContextThemeWrapper
import androidx.annotation.DrawableRes
import com.google.android.material.chip.Chip

data class FilterItem(
    val id: Int,
    val text: String,
    @DrawableRes val icon: Int? = null,
    val iconSize: Float = 26.0f,
    @DrawableRes val closeIcon: Int? = null
)

fun FilterItem.toChip(context: Context) : Chip{
    val chip = Chip(ContextThemeWrapper(context, R.style.Widget_MaterialComponents_Chip_Choice))

    chip.text = text
    chip

    return chip
}