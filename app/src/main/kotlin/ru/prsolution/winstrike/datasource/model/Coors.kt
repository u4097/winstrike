package ru.prsolution.winstrike.datasource.model

import com.squareup.moshi.Json

class Coors  (
	@field:Json(name = "id")
	val id: String? = null,
	@field:Json(name = "x")
	val x: Int? = null,
	@field:Json(name = "y")
	val y: Int? = null,
	@field:Json(name = "angle")
	val angle: Double? = null,
	@field:Json(name = "type")
	val type: Int? = null
)