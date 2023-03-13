package com.bksahabrothersfsm.features.orderList.model

import com.bksahabrothersfsm.base.BaseResponse


class ReturnListResponseModel: BaseResponse() {
    var return_list: ArrayList<ReturnDataModel>? = null
}