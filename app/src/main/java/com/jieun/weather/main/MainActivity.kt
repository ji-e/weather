package com.jieun.weather.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DiffUtil
import com.jieun.weather.R
import com.jieun.weather.base.BaseActivity
import com.jieun.weather.base.BaseMultiViewAdapter
import com.jieun.weather.databinding.ActivityMainBinding
import com.jieun.weather.enum.GeoItem
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupBinding()
        setRecyclerView()
        setupData()
    }

    private fun setupBinding() {
        with(binding) {
            vm = viewModel
        }
        setupLoadingObserver(viewModel)
    }

    private fun setupData() {
        lifecycleScope.launch {
            viewModel.fetchData(GeoItem.SEOUL).join()
            viewModel.fetchData(GeoItem.LONDON).join()
            viewModel.fetchData(GeoItem.CHICAGO).join()
        }
    }

    private fun setRecyclerView() {

        val mainWeatherViewHolderType: MutableList<Pair<Int, Int>> = mutableListOf(
            Pair(R.layout.item_city, BR.item),
            Pair(R.layout.item_weather, BR.item)
        )

        val viewHolderMapper: (MainWeatherItem) -> Int = {
            when (it) {
                is MainWeatherItem.City -> 0
                is MainWeatherItem.Weather -> 1
            }
        }

        val diffUtil = object : DiffUtil.ItemCallback<MainWeatherItem>() {
            override fun areItemsTheSame(
                oldItem: MainWeatherItem,
                newItem: MainWeatherItem
            ): Boolean =
                if (oldItem is MainWeatherItem.Weather && newItem is MainWeatherItem.Weather) {
                    oldItem.dt == newItem.dt
                } else {
                    oldItem == newItem
                }

            override fun areContentsTheSame(
                oldItem: MainWeatherItem,
                newItem: MainWeatherItem
            ): Boolean = oldItem == newItem
        }

        binding.rvWeather.adapter = BaseMultiViewAdapter(
            viewHolderMapper = viewHolderMapper,
            viewHolderType = mainWeatherViewHolderType,
            viewModel = viewModel,
            diffUtil = diffUtil
        )
    }
}
