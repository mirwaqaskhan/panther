package com.byteful.panther.utils

import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


/**
 * Created by Ehitshamshami on 3/8/2018.
 */

inline fun <T>applySchedulersKotlin(): ObservableTransformer<T, T>
{
    return object: ObservableTransformer<T, T> {
        override fun apply(upstream: Observable<T>): ObservableSource<T> {

            return upstream.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())

        }
    }


}