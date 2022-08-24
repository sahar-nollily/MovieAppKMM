package com.saharnollily.android.movieappkmm.domain.usecase

import com.saharnollily.android.movieappkmm.datasource.network.movie.MovieApiService
import com.saharnollily.android.movieappkmm.domain.models.Movie
import com.saharnollily.android.taskappkmm.util.CommonFlow
import com.saharnollily.android.taskappkmm.util.DataState
import com.saharnollily.android.taskappkmm.util.asCommonFlow
import kotlinx.coroutines.flow.flow

class GetMovie(
    private val movieApiService: MovieApiService
) {
    fun execute(): CommonFlow<DataState<List<Movie>>> = flow {
        try {
            emit(DataState.loading())
            val result = movieApiService.getMovies()
            if (result.isEmpty()) {
                emit(DataState.error("No Data"))
            } else
                emit(DataState.data(result))

        } catch (e: Exception) {
            emit(DataState.error(message = "retry"))
        }
    }.asCommonFlow()

}