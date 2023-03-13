package com.bksahabrothersfsm.features.viewAllOrder.interf

import com.bksahabrothersfsm.app.domain.NewOrderGenderEntity
import com.bksahabrothersfsm.features.viewAllOrder.model.ProductOrder
import java.text.FieldPosition

interface NewOrderSizeQtyDelOnClick {
    fun sizeQtySelListOnClick(product_size_qty: ArrayList<ProductOrder>)
    fun sizeQtyListOnClick(product_size_qty: ProductOrder,position: Int)
}