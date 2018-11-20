package com.byteful.panther.ui.activities.mainactivity

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.byteful.panther.api.pojo.request.PlaylistResponse
import com.byteful.panther.ui.activities.mainactivity.MainActivityRepository
import com.byteful.panther.utils.applySchedulersKotlin
import io.reactivex.disposables.Disposable

class MainActivityViewModel(val mainActivityRepository: MainActivityRepository):ViewModel(){


    var playlistResponse=MutableLiveData<PlaylistResponse>()
    var isDataLoading=MutableLiveData<Boolean>()
    var errorThrowable=MutableLiveData<Throwable>()

    var disposable: Disposable?=null

    init {
        isDataLoading.value=true
        callPlaylistApi()
    }

    fun callPlaylistApi(){
        disposable=mainActivityRepository.getPlayList().
                   compose(applySchedulersKotlin()).
                   subscribe({
                       result ->
                       playlistResponse.postValue(result)
                       isDataLoading.value=false
                   },{
                       error ->
                       errorThrowable.postValue(error)
                       isDataLoading.value=false
                   })
    }

    fun getPlayListResponse():LiveData<PlaylistResponse>{
        return playlistResponse
    }

    fun getLoading():LiveData<Boolean>{
        return isDataLoading
    }

    override fun onCleared() {
        if(disposable!=null) {
            disposable!!.dispose()
        }
        super.onCleared()
    }


}