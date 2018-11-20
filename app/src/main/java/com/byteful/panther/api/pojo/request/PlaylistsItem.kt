package com.byteful.panther.api.pojo.request

import com.squareup.moshi.Json

data class PlaylistsItem(

	@Json(name="offline_playlist_url")
	val offlinePlaylistUrl: String? = null,

	@Json(name="cover_image_url")
	val coverImageUrl: String? = null,

	@Json(name="cover_image_preview_url")
	val coverImagePreviewUrl: String? = null,

	@Json(name="name")
	val name: String? = null,

	@Json(name="name_display")
	val nameDisplay: String? = null,

	@Json(name="playlist_url")
	val playlistUrl: String? = null,

	@Json(name="available_replay_time")
	val availableReplayTime: Int? = null,

	@Json(name="description")
	val description: String? = null,

	@Json(name="id")
	val id: Int? = null,

	@Json(name="name_display_html")
	val nameDisplayHtml: String? = null,

	@Json(name="total_playtime")
	val totalPlaytime: Int? = null,

	@Json(name="updated")
	val updated: String? = null
)