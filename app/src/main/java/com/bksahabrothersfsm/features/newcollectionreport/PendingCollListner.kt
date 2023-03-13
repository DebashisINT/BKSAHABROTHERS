package com.bksahabrothersfsm.features.newcollectionreport

import com.bksahabrothersfsm.features.photoReg.model.UserListResponseModel

interface PendingCollListner {
    fun getUserInfoOnLick(obj: PendingCollData)
}