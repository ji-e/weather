package com.jieun.weather.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.jieun.data.entity.common.default
import com.jieun.domain.usecase.geo.GetGeoListUseCase
import com.jieun.domain.usecase.weather.GetWeatherListUseCase
import com.jieun.weather.base.BaseViewModel
import com.jieun.weather.common.DATE_PATTERN_yyyy_MM_dd
import com.jieun.weather.common.DATE_PATTERN_yyyy_MM_dd_HH_mm_ss
import com.jieun.weather.common.stringToStringFormat
import com.jieun.weather.enum.GeoItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getGeoListUseCase: GetGeoListUseCase,
    private val getWeatherListUseCase: GetWeatherListUseCase
) : BaseViewModel() {
    private val _itemList = MutableLiveData<List<MainWeatherItem>>()
    val itemList: LiveData<List<MainWeatherItem>> get() = _itemList

    suspend fun fetchData(geoItem: GeoItem, isRefresh: Boolean = false) =
        viewModelScope.launch {
            val geoResponse =
                getGeoListUseCase.invoke("${geoItem.cityName},${geoItem.countryCode}").firstOrNull()
            val weatherResponse =
                getWeatherListUseCase.invoke(
                    geoResponse?.lat.default(),
                    geoResponse?.lon.default()
                ).list

            var date = weatherResponse.first().dt_txt.stringToStringFormat(
                DATE_PATTERN_yyyy_MM_dd_HH_mm_ss,
                DATE_PATTERN_yyyy_MM_dd
            )
            val weatherList = mutableListOf<MainWeatherItem.Weather>()
            weatherResponse.forEachIndexed { i, weather ->
                val curDate = weather.dt_txt.stringToStringFormat(
                    DATE_PATTERN_yyyy_MM_dd_HH_mm_ss,
                    DATE_PATTERN_yyyy_MM_dd
                )
                if (i == 0 || date != curDate) {
                    date = curDate
                    weatherList.add(
                        MainWeatherItem.Weather(
                            dt = weather.dt,
                            main = weather.main,
                            weather = weather.weather,
                            dt_txt = weather.dt_txt
                        )
                    )
                }
            }

            _itemList.value = if (isRefresh) {
                mutableListOf<MainWeatherItem>().apply {
                    add(MainWeatherItem.City(geoResponse?.name.default()))
                    addAll(weatherList)
                }
            } else {
                val preList = _itemList.value?.toMutableList() ?: mutableListOf<MainWeatherItem>()
                preList.add(MainWeatherItem.City(geoResponse?.name.default()))
                preList.addAll(weatherList)
                preList
            }
        }
}
