package com.saharnollily.android.movieappkmm.datasource.network.movie.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieDto(
    @SerialName("description")
    val description: String = "",
    @SerialName("name")
    val name: String = "",
    @SerialName("poster_path")
    val posterPath: String = ""
)