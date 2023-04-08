package com.berkayertan.recycler.service

import com.berkayertan.recycler.data.StandingModel
import io.reactivex.Single
import retrofit2.http.GET
import java.util.*

interface StandingAPI {

    @GET("2023/getDriverStandings/")
    fun getStandings(): Single<List<StandingModel>>
}


