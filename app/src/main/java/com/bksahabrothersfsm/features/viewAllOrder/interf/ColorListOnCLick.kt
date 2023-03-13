package com.bksahabrothersfsm.features.viewAllOrder.interf

import com.bksahabrothersfsm.app.domain.NewOrderGenderEntity
import com.bksahabrothersfsm.features.viewAllOrder.model.ProductOrder

interface ColorListOnCLick {
    fun colorListOnCLick(size_qty_list: ArrayList<ProductOrder>, adpPosition:Int)
}