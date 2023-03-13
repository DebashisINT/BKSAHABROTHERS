package com.bksahabrothersfsm.features.lead.api

import com.bksahabrothersfsm.features.NewQuotation.api.GetQuotListRegRepository
import com.bksahabrothersfsm.features.NewQuotation.api.GetQutoListApi


object GetLeadRegProvider {
    fun provideList(): GetLeadListRegRepository {
        return GetLeadListRegRepository(GetLeadListApi.create())
    }
}