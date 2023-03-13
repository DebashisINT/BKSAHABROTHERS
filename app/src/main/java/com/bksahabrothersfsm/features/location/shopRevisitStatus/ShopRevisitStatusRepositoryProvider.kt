package com.bksahabrothersfsm.features.location.shopRevisitStatus

import com.bksahabrothersfsm.features.location.shopdurationapi.ShopDurationApi
import com.bksahabrothersfsm.features.location.shopdurationapi.ShopDurationRepository

object ShopRevisitStatusRepositoryProvider {
    fun provideShopRevisitStatusRepository(): ShopRevisitStatusRepository {
        return ShopRevisitStatusRepository(ShopRevisitStatusApi.create())
    }
}