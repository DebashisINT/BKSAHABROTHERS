package com.bksahabrothersfsm.features.viewAllOrder.interf

import com.bksahabrothersfsm.app.domain.NewOrderGenderEntity
import com.bksahabrothersfsm.app.domain.NewOrderProductEntity

interface ProductListNewOrderOnClick {
    fun productListOnClick(product: NewOrderProductEntity)
}