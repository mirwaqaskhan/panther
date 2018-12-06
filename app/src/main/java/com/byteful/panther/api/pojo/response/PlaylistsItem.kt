package com.byteful.panther.api.pojo.response

import com.squareup.moshi.Json

data class PlaylistsItem(

	@Json(name="offline_playlist_url")
	val offline_playlist_url: String,

	@Json(name="cover_image_url")
	val cover_image_url: String,

	@Json(name="cover_image_preview_url")
	val cover_image_preview_url: String,

	@Json(name="name")
	val name: String,

	@Json(name="name_display")
	val name_display: String,

	@Json(name="playlist_url")
	val playlist_url: String,

	@Json(name="available_replay_time")
	val available_replay_time: Int,

	@Json(name="description")
	val description: String,

	@Json(name="id")
	val id: Int,

	@Json(name="name_display_html")
	val name_display_html: String,

	@Json(name="total_playtime")
	val total_playtime: Int,

	@Json(name="updated")
	val updated: String
)