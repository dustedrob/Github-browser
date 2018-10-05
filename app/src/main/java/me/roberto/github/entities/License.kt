package me.roberto.github.entities

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class License(

		@field:Json(name="name")
	val name: String? = null,

		@field:Json(name="spdx_id")
	val spdxId: String? = null,

		@field:Json(name="key")
	val key: String? = null,

		@field:Json(name="url")
	val url: String? = null,

		@field:Json(name="node_id")
	val nodeId: String? = null
): Parcelable