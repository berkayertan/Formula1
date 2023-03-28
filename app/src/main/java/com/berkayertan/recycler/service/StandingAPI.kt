package com.berkayertan.recycler.service

import com.berkayertan.recycler.data.StandingModel
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET

interface StandingAPI {

    @GET("2023/getDriverStandings/?rapidapi-key=40cfea8fc6msh4e63f74aa9f16bfp1cdc3djsn28a6708d4c15")
            fun getStandings():Single<List<StandingModel>>
}


