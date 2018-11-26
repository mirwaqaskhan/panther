package com.byteful.panther.api

import com.byteful.panther.api.endpoint.EndPoints
import com.byteful.panther.api.pojo.request.PlaylistResponse
import retrofit2.http.GET
import io.reactivex.Observable

interface PantharApiService {


    @GET(EndPoints.ListEndPoint)
    fun getMusicList():Observable<PlaylistResponse>


}