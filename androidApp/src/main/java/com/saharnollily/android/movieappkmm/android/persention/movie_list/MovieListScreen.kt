package com.saharnollily.android.movieappkmm.android.persention.movie_list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import com.saharnollily.android.movieappkmm.datasource.network.movie.MovieApiServiceImp.Companion.IMAGE_BASE_URL
import com.saharnollily.android.movieappkmm.domain.models.Movie
import com.saharnollily.android.movieappkmm.persentaion.MovieListState
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.glide.GlideImage
import kotlinx.coroutines.NonDisposableHandle.parent


@Composable
fun MovieListScreen() {

    val movieListViewModel: MovieListViewModel = hiltViewModel()
    val state = movieListViewModel.movieListState.value

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        when {
            state.data.isNotEmpty() -> OnSuccess(data = state.data)
            state.error.isNotBlank() -> OnError({ movieListViewModel.getMovies() }, state.error)
            state.isLoading -> OnLoading()
        }
    }

}

@Composable
fun OnSuccess(data: List<Movie>) {
    LazyColumn() {
        itemsIndexed(data) { index: Int, item: Movie ->
            Card(
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentHeight()
                    .padding(vertical = 5.dp, horizontal = 20.dp),
                shape = RoundedCornerShape(5.dp),
                elevation = 5.dp,
                backgroundColor = Color.LightGray
            ) {
                Column() {
                    GlideImage(
                        imageModel = IMAGE_BASE_URL + item.posterPath,
                        circularReveal = CircularReveal(duration = 250),
                        loading = {
                           OnLoading()
                        },
                    )
                    Text(text = item.name, modifier = Modifier.padding(20.dp))
                }
            }
        }

    }

}

@Composable
fun OnLoading() {
    CircularProgressIndicator()
}

@Composable
fun OnError(onClick: () -> Unit, errorMessage: String) {
    Button(onClick = onClick) {
        Text(text = errorMessage)
    }
}