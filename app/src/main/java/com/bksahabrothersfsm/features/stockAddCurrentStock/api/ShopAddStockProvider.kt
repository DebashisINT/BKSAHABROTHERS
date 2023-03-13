package com.bksahabrothersfsm.features.stockAddCurrentStock.api

import com.bksahabrothersfsm.features.location.shopRevisitStatus.ShopRevisitStatusApi
import com.bksahabrothersfsm.features.location.shopRevisitStatus.ShopRevisitStatusRepository

object ShopAddStockProvider {
    fun provideShopAddStockRepository(): ShopAddStockRepository {
        return ShopAddStockRepository(ShopAddStockApi.create())
    }
}