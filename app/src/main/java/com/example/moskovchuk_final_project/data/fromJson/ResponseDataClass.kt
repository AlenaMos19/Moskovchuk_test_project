package com.example.moskovchuk_final_project.data.fromJson


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ResponseDataClass(
    @Json(name = "info") val info: Info,
    @Json(name = "results") val results: List<Result>
)