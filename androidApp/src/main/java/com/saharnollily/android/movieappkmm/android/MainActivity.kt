package com.saharnollily.android.movieappkmm.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.saharnollily.android.movieappkmm.android.persention.movie_list.MovieListScreen
import com.saharnollily.android.movieappkmm.android.persention.movie_list.MovieListViewModel
import com.saharnollily.android.movieappkmm.android.ui.theme.MovieAppKMMTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieAppKMMTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    MovieListScreen()
                }
            }
        }
    }
}