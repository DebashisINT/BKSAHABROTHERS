package com.bksahabrothersfsm.features.weather.api

import com.bksahabrothersfsm.base.BaseResponse
import com.bksahabrothersfsm.features.task.api.TaskApi
import com.bksahabrothersfsm.features.task.model.AddTaskInputModel
import com.bksahabrothersfsm.features.weather.model.ForeCastAPIResponse
import com.bksahabrothersfsm.features.weather.model.WeatherAPIResponse
import io.reactivex.Observable

class WeatherRepo(val apiService: WeatherApi) {
    fun getCurrentWeather(zipCode: String): Observable<WeatherAPIResponse> {
        return apiService.getTodayWeather(zipCode)
    }

    fun getWeatherForecast(zipCode: String): Observable<ForeCastAPIResponse> {
        return apiService.getForecast(zipCode)
    }
}