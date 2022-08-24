package com.saharnollily.android.movieappkmm.android.persention.movie_list

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saharnollily.android.movieappkmm.domain.usecase.GetMovie
import com.saharnollily.android.movieappkmm.persentaion.MovieListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val getMovie: GetMovie
) : ViewModel() {

    private var _movieListState: MutableState<MovieListState> = mutableStateOf(MovieListState())
    val movieListState: State<MovieListState>
        get() = _movieListState

    init {
        getMovies()
    }

    fun getMovies() {
        getMovie.execute().onEach { dataState ->
            when {
                dataState.isLoading -> {
                    _movieListState.value = MovieListState(isLoading = dataState.isLoading)
                    Log.d("SaharTest", "loading")
                }
                dataState.data != null -> {
                    _movieListState.value = MovieListState(data = dataState.data ?: emptyList())
                    Log.d("SaharTest", dataState.data.toString())
                }
                dataState.message != null -> {
                    _movieListState.value = MovieListState(error = dataState.message ?: "")
                    Log.d("SaharTest", dataState.message.toString())
                }
                else -> {
                    Log.d("SaharTest", "bla ")
                }
            }
        }.launchIn(viewModelScope)
    }

}