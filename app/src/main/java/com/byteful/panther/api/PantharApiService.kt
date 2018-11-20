package com.byteful.panther.api

import com.byteful.panther.api.pojo.request.PlaylistResponse
import retrofit2.http.GET
import java.util.*
import io.reactivex.Observable

interface PantharApiService {


    @GET(EndPoints.ListEndPoint)
    fun getMusicList():Observable<PlaylistResponse>
}