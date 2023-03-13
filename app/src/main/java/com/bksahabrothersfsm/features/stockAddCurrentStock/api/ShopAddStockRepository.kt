package com.bksahabrothersfsm.features.stockAddCurrentStock.api

import com.bksahabrothersfsm.base.BaseResponse
import com.bksahabrothersfsm.features.location.model.ShopRevisitStatusRequest
import com.bksahabrothersfsm.features.location.shopRevisitStatus.ShopRevisitStatusApi
import com.bksahabrothersfsm.features.stockAddCurrentStock.ShopAddCurrentStockRequest
import com.bksahabrothersfsm.features.stockAddCurrentStock.model.CurrentStockGetData
import com.bksahabrothersfsm.features.stockCompetetorStock.model.CompetetorStockGetData
import io.reactivex.Observable

class ShopAddStockRepository (val apiService : ShopAddStockApi){
    fun shopAddStock(shopAddCurrentStockRequest: ShopAddCurrentStockRequest?): Observable<BaseResponse> {
        return apiService.submShopAddStock(shopAddCurrentStockRequest)
    }

    fun getCurrStockList(sessiontoken: String, user_id: String, date: String): Observable<CurrentStockGetData> {
        return apiService.getCurrStockListApi(sessiontoken, user_id, date)
    }

}