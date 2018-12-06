package com.byteful.panther.api

import com.byteful.panther.api.endpoint.EndPoints
import com.byteful.panther.api.pojo.response.PlaylistResponse
import com.byteful.panther.api.pojo.response.playlistdetail.DetailResponse
import retrofit2.http.GET
import io.reactivex.Observable
import retrofit2.http.Path
import retrofit2.http.Url

interface PantharApiService {


    @GET(EndPoints.ListEndPoint)
    fun getMusicList(@Path("path_ID") ppathID:Int):Observable<PlaylistResponse>

    @GET
    fun getDetailList(@Url url:String):Observable<DetailResponse>

}
