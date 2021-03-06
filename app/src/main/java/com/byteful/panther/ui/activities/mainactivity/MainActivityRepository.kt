package com.byteful.panther.ui.activities.mainactivity

import com.byteful.panther.ProjectApplication
import com.byteful.panther.api.PantharApiService
import com.byteful.panther.api.pojo.response.PlaylistResponse
import com.byteful.panther.api.pojo.response.playlistdetail.DetailResponse
import javax.inject.Inject
import io.reactivex.Observable
/**
 * Created by Shami on 5/6/2018.
 */

public class MainActivityRepository{

    @Inject
    lateinit var pantharApiService: PantharApiService

    init {
        ProjectApplication().appComponent.inject(this)
    }

    fun getPlayList():Observable<PlaylistResponse>{
        return pantharApiService.getMusicList(1)
    }



    fun getDetailResponse(detailResponseUrl:String):Observable<DetailResponse> {
        return pantharApiService.getDetailList(detailResponseUrl)
    }
}