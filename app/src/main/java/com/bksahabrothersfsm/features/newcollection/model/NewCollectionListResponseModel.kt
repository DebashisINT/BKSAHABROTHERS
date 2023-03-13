package com.bksahabrothersfsm.features.newcollection.model

import com.bksahabrothersfsm.app.domain.CollectionDetailsEntity
import com.bksahabrothersfsm.base.BaseResponse
import com.bksahabrothersfsm.features.shopdetail.presentation.model.collectionlist.CollectionListDataModel

/**
 * Created by Saikat on 15-02-2019.
 */
class NewCollectionListResponseModel : BaseResponse() {
    //var collection_list: ArrayList<CollectionListDataModel>? = null
    var collection_list: ArrayList<CollectionDetailsEntity>? = null
}