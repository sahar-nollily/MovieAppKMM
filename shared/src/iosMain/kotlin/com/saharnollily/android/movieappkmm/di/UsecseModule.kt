package com.saharnollily.android.movieappkmm.di

import com.saharnollily.android.movieappkmm.datasource.network.movie.MovieApiService
import com.saharnollily.android.movieappkmm.domain.usecase.GetMovie

class UsecaseModule(
    private val movieApiService: MovieApiService
) {

    val getMovie: GetMovie by lazy {
        GetMovie(movieApiService = movieApiService)
    }
}