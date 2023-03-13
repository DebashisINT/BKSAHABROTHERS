package com.bksahabrothersfsm.features.photoReg.present

import com.bksahabrothersfsm.app.domain.ProspectEntity
import com.bksahabrothersfsm.features.photoReg.model.UserListResponseModel

interface DsStatusListner {
    fun getDSInfoOnLick(obj: ProspectEntity)
}