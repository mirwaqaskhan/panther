package com.byteful.panther.api.pojo.response.playlistdetail

import com.squareup.moshi.Json

data class DetailResponse(

	@Json(name="file_url")
	val file_url: String? = null,

	@Json(name="cover_image_url")
	val cover_image_url: String? = null,

	@Json(name="name_offline_display")
	val name_offline_display: String? = null,

	@Json(name="dash_manifest_uri")
	val dash_manifest_uri: String? = null,

	@Json(name="description")
	val description: String,

	@Json(name="name_display_html")
	val nameDisplayHtml: String? = null,

	@Json(name="track_list")
	val track_list: List<TrackListItem>? =null,

	@Json(name="offline_playlist_url")
	val offline_playlist_url: String? = null,

	@Json(name="hls_manifest_uri")
	val hls_manifest_uri: String? = null,

	@Json(name="cover_image_preview_url")
	val cover_image_preview_url: String? = null,

	@Json(name="name")
	val name: String? = null,

	@Json(name="name_display")
	val name_display: String? = null,

	@Json(name="playlist_url")
	val playlist_url: String? = null,

	@Json(name="available_replay_time")
	val available_replay_time: Int? = null,

	@Json(name="id")
	val id: Int? = null,

	@Json(name="article_list")
	val article_list: List<ArticleListItem?>? = null,

	@Json(name="total_playtime")
	val total_playtime: Int? = null,

	@Json(name="track_schedule")
	val track_schedule: List<TrackScheduleItem?>? = null,

	@Json(name="updated")
	val updated: String? = null
)