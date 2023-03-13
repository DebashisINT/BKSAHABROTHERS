package com.bksahabrothersfsm.features.login.model.productlistmodel

import com.bksahabrothersfsm.app.domain.ModelEntity
import com.bksahabrothersfsm.app.domain.ProductListEntity
import com.bksahabrothersfsm.base.BaseResponse

class ModelListResponse: BaseResponse() {
    var model_list: ArrayList<ModelEntity>? = null
}