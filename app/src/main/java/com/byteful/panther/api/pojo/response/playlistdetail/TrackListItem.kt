package com.byteful.panther.api.pojo.response.playlistdetail


import com.squareup.moshi.Json

data class TrackListItem(

	@Json(name="duration")
	val duration: Int? = null,

	@Json(name="file_url")
	val file_url: String? = null,

	@Json(name="artist")
	val artist: String? = null,

	@Json(name="hls_manifest_uri")
	val hls_manifest_uri: String? = null,

	@Json(name="album")
	val album: String? = null,

	@Json(name="cover_image_url")
	val cover_image_url: String? = null,

	@Json(name="dash_manifest_uri")
	val dash_manifest_uri: String? = null,

	@Json(name="id")
	val id: Int? = null,

	@Json(name="title")
	val title: String? = null,

	@Json(name="is_explicit")
	val is_explicit: Boolean
)