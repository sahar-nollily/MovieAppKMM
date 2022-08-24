package com.saharnollily.android.movieappkmm.di

import com.saharnollily.android.movieappkmm.datasource.network.KtorClientFactory
import com.saharnollily.android.movieappkmm.datasource.network.movie.MovieApiService
import com.saharnollily.android.movieappkmm.datasource.network.movie.MovieApiServiceImp
import io.ktor.client.*

class NetworkModule {

    private val httpClient: HttpClient by lazy {
        KtorClientFactory().build()
    }

    val movieApiService: MovieApiService by lazy {
        MovieApiServiceImp(httpClient)
    }

}