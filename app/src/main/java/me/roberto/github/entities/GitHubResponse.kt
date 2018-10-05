package me.roberto.github.entities

import com.squareup.moshi.Json

data class GitHubResponse(

	@field:Json(name="total_count")
	val totalCount: Int? = null,

	@field:Json(name="incomplete_results")
	val incompleteResults: Boolean? = null,

	@field:Json(name="items")
	val items: List<Repository>? = null
)