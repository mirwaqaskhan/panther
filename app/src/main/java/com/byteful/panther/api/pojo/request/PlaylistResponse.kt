package com.byteful.panther.api.pojo.request

import com.squareup.moshi.Json


data class PlaylistResponse(

	@Json(name="name")
	val name: String? = null,

	@Json(name="playlists")
	val playlists: List<PlaylistsItem>? = null
)