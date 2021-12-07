package app.myfood.com

import android.content.Context
import android.view.ContextThemeWrapper
import android.view.LayoutInflater
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
    val chip = if (closeIcon == null) {
        LayoutInflater.from(context).inflate(R.layout.chip_choice, null, false) as Chip
    } else {
        Chip(ContextThemeWrapper(context, R.style.Widget_MaterialComponents_Chip_Choice))
    }

    chip.text = text

    return chip
}