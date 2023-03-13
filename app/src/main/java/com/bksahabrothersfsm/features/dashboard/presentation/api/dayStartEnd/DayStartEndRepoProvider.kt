package com.bksahabrothersfsm.features.dashboard.presentation.api.dayStartEnd

import com.bksahabrothersfsm.features.stockCompetetorStock.api.AddCompStockApi
import com.bksahabrothersfsm.features.stockCompetetorStock.api.AddCompStockRepository

object DayStartEndRepoProvider {
    fun dayStartRepositiry(): DayStartEndRepository {
        return DayStartEndRepository(DayStartEndApi.create())
    }

}