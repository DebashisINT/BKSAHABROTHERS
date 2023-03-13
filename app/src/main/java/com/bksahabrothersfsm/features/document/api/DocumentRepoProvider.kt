package com.bksahabrothersfsm.features.document.api

import com.bksahabrothersfsm.features.dymanicSection.api.DynamicApi
import com.bksahabrothersfsm.features.dymanicSection.api.DynamicRepo

object DocumentRepoProvider {
    fun documentRepoProvider(): DocumentRepo {
        return DocumentRepo(DocumentApi.create())
    }

    fun documentRepoProviderMultipart(): DocumentRepo {
        return DocumentRepo(DocumentApi.createImage())
    }
}