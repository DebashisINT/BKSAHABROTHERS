package com.bksahabrothersfsm.features.activities.api

import com.bksahabrothersfsm.features.member.api.TeamApi
import com.bksahabrothersfsm.features.member.api.TeamRepo

object ActivityRepoProvider {
    fun activityRepoProvider(): ActivityRepo {
        return ActivityRepo(ActivityApi.create())
    }

    fun activityImageRepoProvider(): ActivityRepo {
        return ActivityRepo(ActivityApi.createImage())
    }
}