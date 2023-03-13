package com.bksahabrothersfsm.features.viewAllOrder.interf

import com.bksahabrothersfsm.app.domain.NewOrderColorEntity
import com.bksahabrothersfsm.app.domain.NewOrderProductEntity

interface ColorListNewOrderOnClick {
    fun productListOnClick(color: NewOrderColorEntity)
}