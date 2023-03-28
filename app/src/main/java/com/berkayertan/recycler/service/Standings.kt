package com.berkayertan.recycler.service

import com.berkayertan.recycler.data.StandingModel
import io.reactivex.Single
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class Standings {
    private val BASE_URL ="https://formula-1-standing-api.p.rapidapi.com/"
    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build().create(StandingAPI::class.java)


    fun getData(): Single<List<StandingModel>> {
        return api.getStandings()

    }
}