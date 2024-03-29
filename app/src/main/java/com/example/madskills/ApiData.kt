package com.example.madskills

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class ApiData {
        companion object {
            const val count = 10
            val api by lazy { RetrofitClient.callApi() }
            var disposable: Disposable? = null
            fun apiData(callback:Response){
                disposable = api.getCatlog(count)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe ({
                            result ->
                        callback.data(result,true)
                    }, { error ->
                        error.printStackTrace()
                    })

            }

        }
        interface Response {
            fun data(data:Model.Result,status:Boolean)
        }
    }


