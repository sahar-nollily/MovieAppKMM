package com.saharnollily.android.movieappkmm.util

import com.saharnollily.android.movieappkmm.datasource.network.movie.models.MovieDto
import com.saharnollily.android.movieappkmm.domain.models.Movie

fun MovieDto.toMovie(): Movie {
    return Movie(
        description = description,
        name = name,
        posterPath = posterPath
    )
}

fun List<MovieDto>.toMovieList(): List<Movie> {
    return map {
        it.toMovie()
    }
}

