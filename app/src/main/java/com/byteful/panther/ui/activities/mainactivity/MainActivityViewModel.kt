package com.byteful.panther.ui.activities.mainactivity

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import com.byteful.panther.SingleLiveEvent
import com.byteful.panther.api.pojo.response.PlaylistResponse
import com.byteful.panther.api.pojo.response.playlistdetail.DetailResponse
import com.byteful.panther.api.pojo.response.playlistdetail.TrackListItem
import com.byteful.panther.utils.applySchedulersKotlin
import io.reactivex.disposables.Disposable
import java.util.*

class MainActivityViewModel(val mainActivityRepository: MainActivityRepository):ViewModel(){


    var playlistResponse= MutableLiveData<PlaylistResponse>()
    var isDataLoading=SingleLiveEvent<Boolean>()
    var errorThrowable=SingleLiveEvent<Throwable>()
    var playlistDetailResponse=SingleLiveEvent<DetailResponse>()
    var playlistDetailResponseObserver=ObservableField<DetailResponse>()
    lateinit var trackList:List<TrackListItem>

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

    fun callDetailResponseApi(url:String){
        disposable=mainActivityRepository.getDetailResponse(url).
                compose(applySchedulersKotlin()).
                subscribe({
                    result ->
                    result.track_list?.let {
                        trackList=it
                        playlistDetailResponse.postValue(result)
                        playlistDetailResponseObserver.set(result)
                    }
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

    fun getOfferDetailListResponse():LiveData<DetailResponse>{
        return playlistDetailResponse
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