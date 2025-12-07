package com.example.test_lab_week_12.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
data class MovieEntity(
    @PrimaryKey val id: Int,
    val title: String,
    val releaseDate: String?,
    val overview: String?,
    val posterPath: String?,
    val popularity: Double?
)
