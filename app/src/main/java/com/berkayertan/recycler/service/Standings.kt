package com.berkayertan.recycler.service

import com.berkayertan.recycler.data.ConstructorStandingModel
import com.berkayertan.recycler.data.RaceResultsModel
import com.berkayertan.recycler.data.StandingModel
import io.reactivex.Single
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class Standings {
    private val BASE_URL = "https://formula-1-standing-api.p.rapidapi.com/"
    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(
            OkHttpClient.Builder()
                .addInterceptor { chain ->
                    val request = chain.request()
                        .newBuilder()
                        .addHeader("x-rapidapi-key", "40cfea8fc6msh4e63f74aa9f16bfp1cdc3djsn28a6708d4c15")
                        .build()
                    chain.proceed(request)
                }
                .build()
        )
        .build()
        .create(StandingAPI::class.java)

    fun getData(): Single<List<StandingModel>> {
        return api.getStandings()
    }
    fun getConstructorData(): Single<List<ConstructorStandingModel>> {
        return api.getConstructorStandings()
    }

    fun getRaceResultsData(): Single<List<RaceResultsModel>> {
        return api.getRaceResults()
    }
}