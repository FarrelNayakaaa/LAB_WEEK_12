package com.example.test_lab_week_12.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(

    val id: Int,

    val title: String,

    @Json(name = "release_date")
    val releaseDate: String? = null,

    val overview: String? = null,

    @Json(name = "poster_path")
    val posterPath: String? = null,

    val popularity: Double? = null,

    // Tambahan field wajib untuk menghindari Moshi crash
    @Json(name = "vote_average")
    val voteAverage: Double? = null,

    @Json(name = "vote_count")
    val voteCount: Int? = null,

    @Json(name = "adult")
    val adult: Boolean? = null,

    @Json(name = "backdrop_path")
    val backdropPath: String? = null,

    @Json(name = "video")
    val video: Boolean? = null,

    @Json(name = "original_title")
    val originalTitle: String? = null,

    @Json(name = "original_language")
    val originalLanguage: String? = null,

    @Json(name = "genre_ids")
    val genreIds: List<Int>? = null
) : Parcelable
