package com.byteful.panther.api.pojo.response.playlistdetail


import com.squareup.moshi.Json

data class ArticleListItem(

	@Json(name="playlist")
	val playlist: Int? = null,

	@Json(name="image_url")
	val imageUrl: String? = null,

	@Json(name="id")
	val id: Int? = null,

	@Json(name="title")
	val title: String? = null,

	@Json(name="content")
	val content: String? = null
)