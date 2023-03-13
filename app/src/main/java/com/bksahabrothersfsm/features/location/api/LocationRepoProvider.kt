package com.bksahabrothersfsm.features.location.api

import com.bksahabrothersfsm.features.location.shopdurationapi.ShopDurationApi
import com.bksahabrothersfsm.features.location.shopdurationapi.ShopDurationRepository


object LocationRepoProvider {
    fun provideLocationRepository(): LocationRepo {
        return LocationRepo(LocationApi.create())
    }
}