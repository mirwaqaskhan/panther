package com.byteful.panther.api.pojo.request

import com.squareup.moshi.Json

data class PlaylistsItem(

	@Json(name="offline_playlist_url")
	val offlinePlaylistUrl: String,

	@Json(name="cover_image_url")
	val coverImageUrl: String,

	@Json(name="cover_image_preview_url")
	val coverImagePreviewUrl: String,

	@Json(name="name")
	val name: String,

	@Json(name="name_display")
	val nameDisplay: String,

	@Json(name="playlist_url")
	val playlistUrl: String,

	@Json(name="available_replay_time")
	val availableReplayTime: Int,

	@Json(name="description")
	val description: String,

	@Json(name="id")
	val id: Int,

	@Json(name="name_display_html")
	val nameDisplayHtml: String,

	@Json(name="total_playtime")
	val totalPlaytime: Int,

	@Json(name="updated")
	val updated: String
)