package com.saharnollily.android.movieappkmm.datasource.network.movie

import com.saharnollily.android.movieappkmm.domain.models.Movie

interface MovieApiService {

    suspend fun getMovies(): List<Movie>

}