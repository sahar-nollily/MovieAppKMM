package com.saharnollily.android.movieappkmm.android.di

import com.saharnollily.android.movieappkmm.datasource.network.movie.MovieApiService
import com.saharnollily.android.movieappkmm.domain.usecase.GetMovie
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UsecaseModule {

    @Singleton
    @Provides
    fun provideGetMovies(
        movieApiService: MovieApiService
    ): GetMovie {
        return GetMovie(movieApiService = movieApiService)
    }
}