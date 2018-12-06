package com.byteful.panther.api.pojo.response.playlistdetail

import com.squareup.moshi.Json


data class TrackScheduleItem(

	@Json(name="start_time_offset")
	val start_time_offset: Int? = null,

	@Json(name="id")
	val id: Int? = null,

	@Json(name="track")
	val track: Int? = null
)