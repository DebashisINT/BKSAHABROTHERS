package com.bksahabrothersfsm.features.stock.api

import com.bksahabrothersfsm.app.Pref
import com.bksahabrothersfsm.base.BaseResponse
import com.bksahabrothersfsm.features.stock.model.AddStockInputParamsModel
import com.bksahabrothersfsm.features.stock.model.NewStockListResponseModel
import io.reactivex.Observable

/**
 * Created by Saikat on 17-09-2019.
 */
class StockRepository(val apiService: StockApi) {

    fun addStock(addStock: AddStockInputParamsModel): Observable<BaseResponse> {
        return apiService.addStock(addStock)
    }

    fun getStockList(): Observable<NewStockListResponseModel> {
        return apiService.getStockList(Pref.session_token!!, Pref.user_id!!)
    }
}