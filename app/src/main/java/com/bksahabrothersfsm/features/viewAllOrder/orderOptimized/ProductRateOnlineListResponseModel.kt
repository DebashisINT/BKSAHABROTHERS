package com.bksahabrothersfsm.features.viewAllOrder.orderOptimized

import com.bksahabrothersfsm.app.domain.ProductOnlineRateTempEntity
import com.bksahabrothersfsm.base.BaseResponse
import com.bksahabrothersfsm.features.login.model.productlistmodel.ProductRateDataModel
import java.io.Serializable

class ProductRateOnlineListResponseModel: BaseResponse(), Serializable {
    var product_rate_list: ArrayList<ProductOnlineRateTempEntity>? = null
}