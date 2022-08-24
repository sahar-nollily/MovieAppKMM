package com.saharnollily.android.movieappkmm.datasource.network.movie

import com.saharnollily.android.movieappkmm.datasource.network.movie.models.MovieResponse
import com.saharnollily.android.movieappkmm.domain.models.Movie
import com.saharnollily.android.movieappkmm.util.toMovieList
import io.ktor.client.*
import io.ktor.client.request.*

class MovieApiServiceImp(
    private val httpClient: HttpClient,
) : MovieApiService {

    override suspend fun getMovies(): List<Movie> {
        return httpClient.get<MovieResponse> {
            url(BASE_URL + "movie/550/lists?page=91")
            header("Authorization", ACCESS_TOKEN)
        }.results.toMovieList()
    }

    companion object {
        const val ACCESS_TOKEN =
            "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI1ZGNkMzU4NjlkYmE3MjY2NmRiZjg5YTZiOThmNGIyOSIsInN1YiI6IjYxOTM3ZmZiMDE3NTdmMDA4YTdjOWY4ZiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.XOo-z368-6P9LE26PjPPfUg638QEwe67KKoZShSkiSw"
        const val BASE_URL = "https://api.themoviedb.org/3/"
        const val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/original"
    }
}