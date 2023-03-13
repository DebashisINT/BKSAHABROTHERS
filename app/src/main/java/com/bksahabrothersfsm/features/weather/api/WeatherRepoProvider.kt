package com.bksahabrothersfsm.features.weather.api

import com.bksahabrothersfsm.features.task.api.TaskApi
import com.bksahabrothersfsm.features.task.api.TaskRepo

object WeatherRepoProvider {
    fun weatherRepoProvider(): WeatherRepo {
        return WeatherRepo(WeatherApi.create())
    }
}