package ru.prsolution.winstrike.datasource.model

import com.squareup.moshi.Json

class Layout (
	@field:Json(name = "places")
	val places: List<Place>? = null,
	@field:Json(name = "room_pid")
	val roomPid: String? = null,
	@field:Json(name = "public_id")
	val publicId: String? = null,
	@field:Json(name = "name")
	val name: String? = null,
	@field:Json(name = "create_at")
	val createAt: String? = null
)