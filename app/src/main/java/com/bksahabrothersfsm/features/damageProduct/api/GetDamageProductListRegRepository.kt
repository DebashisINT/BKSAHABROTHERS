package com.bksahabrothersfsm.features.damageProduct.api

import android.content.Context
import android.net.Uri
import android.text.TextUtils
import android.util.Log
import com.bksahabrothersfsm.app.FileUtils
import com.bksahabrothersfsm.base.BaseResponse
import com.bksahabrothersfsm.features.NewQuotation.model.*
import com.bksahabrothersfsm.features.addshop.model.AddShopRequestData
import com.bksahabrothersfsm.features.addshop.model.AddShopResponse
import com.bksahabrothersfsm.features.damageProduct.model.DamageProductResponseModel
import com.bksahabrothersfsm.features.damageProduct.model.delBreakageReq
import com.bksahabrothersfsm.features.damageProduct.model.viewAllBreakageReq
import com.bksahabrothersfsm.features.login.model.userconfig.UserConfigResponseModel
import com.bksahabrothersfsm.features.myjobs.model.WIPImageSubmit
import com.bksahabrothersfsm.features.photoReg.model.*
import com.fasterxml.jackson.databind.ObjectMapper
import com.google.gson.Gson
import io.reactivex.Observable
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File

class GetDamageProductListRegRepository(val apiService : GetDamageProductListApi) {

    fun viewBreakage(req: viewAllBreakageReq): Observable<DamageProductResponseModel> {
        return apiService.viewBreakage(req)
    }

    fun delBreakage(req: delBreakageReq): Observable<BaseResponse>{
        return apiService.BreakageDel(req.user_id!!,req.breakage_number!!,req.session_token!!)
    }

}