package com.saharnollily.android.movieappkmm.android.di

import com.saharnollily.android.movieappkmm.datasource.network.KtorClientFactory
import com.saharnollily.android.movieappkmm.datasource.network.movie.MovieApiService
import com.saharnollily.android.movieappkmm.datasource.network.movie.MovieApiServiceImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideHttpClient(): HttpClient {
        return KtorClientFactory().build()
    }

    @Singleton
    @Provides
    fun provideMovieApiService(
        httpClient: HttpClient
    ): MovieApiService {
        return MovieApiServiceImp(httpClient)
    }
}