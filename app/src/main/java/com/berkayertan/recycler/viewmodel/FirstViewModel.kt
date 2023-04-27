package com.berkayertan.recycler.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.berkayertan.recycler.data.ConstructorStandingModel
import com.berkayertan.recycler.data.RaceResultsModel
import com.berkayertan.recycler.data.StandingModel
import com.berkayertan.recycler.service.Standings
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class FirstViewModel : ViewModel() {

    private val standings = Standings()
    private val disposable = CompositeDisposable()
    val drivers = MutableLiveData<List<StandingModel>>()
    val constructors = MutableLiveData<List<ConstructorStandingModel>>()
    val results = MutableLiveData<List<RaceResultsModel>>()

    fun refreshData() {
        getDataFromAPI()
    }

    fun constData() {
        getConstDataFromAPI()
    }

    fun resultData() {
        getRaceResultsDataFromAPI()
    }


    fun getDataFromAPI() {
        disposable.add(
            standings.getData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<StandingModel>>() {
                    override fun onSuccess(t: List<StandingModel>) {
                        drivers.value = t
                    }

                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                    }
                })
        )
    }

    fun getConstDataFromAPI() {
        disposable.add(
            standings.getConstructorData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<ConstructorStandingModel>>() {
                    override fun onSuccess(t: List<ConstructorStandingModel>) {
                        constructors.value = t
                    }

                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                    }
                })
        )
    }

    fun getRaceResultsDataFromAPI(){
        disposable.add(
            standings.getRaceResultsData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<RaceResultsModel>>() {
                    override fun onSuccess(t: List<RaceResultsModel>) {
                        results.value = t
                    }

                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                    }
                })
                )
    }
}
