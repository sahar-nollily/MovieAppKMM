package com.saharnollily.android.movieappkmm.persentaion

import com.saharnollily.android.movieappkmm.domain.models.Movie

data class MovieListState(
    var isLoading: Boolean = false,
    var error: String = "",
    var data: List<Movie> = emptyList(),
) {
    constructor() : this(
        isLoading = false,
        error = "",
        data = emptyList()
    )
}