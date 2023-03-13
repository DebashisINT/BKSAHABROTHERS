package com.bksahabrothersfsm.features.nearbyuserlist.api

import com.bksahabrothersfsm.app.Pref
import com.bksahabrothersfsm.features.nearbyuserlist.model.NearbyUserResponseModel
import com.bksahabrothersfsm.features.newcollection.model.NewCollectionListResponseModel
import com.bksahabrothersfsm.features.newcollection.newcollectionlistapi.NewCollectionListApi
import io.reactivex.Observable

class NearbyUserRepo(val apiService: NearbyUserApi) {
    fun nearbyUserList(): Observable<NearbyUserResponseModel> {
        return apiService.getNearbyUserList(Pref.session_token!!, Pref.user_id!!)
    }
}