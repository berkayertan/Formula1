package com.berkayertan.recycler.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
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
}
