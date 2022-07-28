package com.jieun.weather.base

import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jieun.domain.dto.WeatherWeatherDto
import com.jieun.weather.common.DATE_PATTERN_yyyy_MM_dd
import com.jieun.weather.common.DATE_PATTERN_yyyy_MM_dd_HH_mm_ss
import com.jieun.weather.common.stringToStringFormat

@BindingAdapter("bindItemList")
fun RecyclerView.bindItemList(item: List<Any>?) {
    if (item == null) return

    @Suppress("UNCHECKED_CAST")
    (adapter as? BaseMultiViewAdapter<Any>)?.run {
        submitList(item)
    }
}

@BindingAdapter("bindWeatherDate")
fun TextView.bindWeatherDate(date: String) {
    this.text = date.stringToStringFormat(DATE_PATTERN_yyyy_MM_dd_HH_mm_ss, DATE_PATTERN_yyyy_MM_dd)
}

@BindingAdapter("bindWeatherIcon")
fun TextView.bindWeatherIcon(icon: List<WeatherWeatherDto>) {
    val type = icon.firstOrNull()?.id
    val resId = resources.getIdentifier("wi_owm_$type", "string", context.packageName)
    this.text = resources.getString(resId)
}

@BindingAdapter("bindWeatherDescription")
fun TextView.bindWeatherDescription(description: List<WeatherWeatherDto>) {
    this.text = description.firstOrNull()?.description
}
