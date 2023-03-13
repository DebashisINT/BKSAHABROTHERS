package com.bksahabrothersfsm.features.viewAllOrder.interf

import com.bksahabrothersfsm.app.domain.NewOrderProductEntity
import com.bksahabrothersfsm.app.domain.NewOrderSizeEntity

interface SizeListNewOrderOnClick {
    fun sizeListOnClick(size: NewOrderSizeEntity)
}