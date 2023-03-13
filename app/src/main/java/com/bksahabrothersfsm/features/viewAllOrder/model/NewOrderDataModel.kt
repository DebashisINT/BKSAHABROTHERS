package com.bksahabrothersfsm.features.viewAllOrder.model

import com.bksahabrothersfsm.app.domain.NewOrderColorEntity
import com.bksahabrothersfsm.app.domain.NewOrderGenderEntity
import com.bksahabrothersfsm.app.domain.NewOrderProductEntity
import com.bksahabrothersfsm.app.domain.NewOrderSizeEntity
import com.bksahabrothersfsm.features.stockCompetetorStock.model.CompetetorStockGetDataDtls

class NewOrderDataModel {
    var status:String ? = null
    var message:String ? = null
    var Gender_list :ArrayList<NewOrderGenderEntity>? = null
    var Product_list :ArrayList<NewOrderProductEntity>? = null
    var Color_list :ArrayList<NewOrderColorEntity>? = null
    var size_list :ArrayList<NewOrderSizeEntity>? = null
}

