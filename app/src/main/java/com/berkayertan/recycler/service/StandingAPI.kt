package com.berkayertan.recycler.service

import com.berkayertan.recycler.data.ConstructorStandingModel
import com.berkayertan.recycler.data.RaceResultsModel
import com.berkayertan.recycler.data.StandingModel
import io.reactivex.Single
import retrofit2.http.GET
import java.util.*

interface StandingAPI {

    @GET("2023/getDriverStandings/")
    fun getStandings(): Single<List<StandingModel>>

    @GET("2023/getConstructorStandings/")
    fun getConstructorStandings(): Single<List<ConstructorStandingModel>>

    @GET("2023/getRaceResults")
    fun getRaceResults(): Single<List<RaceResultsModel>>
}


