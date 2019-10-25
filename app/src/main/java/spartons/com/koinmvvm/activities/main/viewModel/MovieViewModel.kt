package spartons.com.koinmvvm.activities.main.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import spartons.com.koinmvvm.R
import spartons.com.koinmvvm.activities.main.data.MovieCollection
import spartons.com.koinmvvm.backend.ServiceUtil
import spartons.com.koinmvvm.util.Constants
import spartons.com.koinmvvm.util.Event

/**
 * Ahsen Saeed}
 * ahsansaeed067@gmail.com}
 * 10/24/19}
 */

class MovieViewModel constructor(private val serviceUtil: ServiceUtil) : ViewModel() {

    private val _uiState = MutableLiveData<MovieDataState>()
    val uiState: LiveData<MovieDataState> get() = _uiState

    init {
        retrieveMovies()
    }

    private fun retrieveMovies() {
        viewModelScope.launch {
            runCatching {
                emitUiState(showProgress = true)
                serviceUtil.popularMovies(apiKey = Constants.API_KEY)
            }.onSuccess {
                emitUiState(movies = Event(it.movies))
            }.onFailure {
                it.printStackTrace()
                emitUiState(error = Event(R.string.internet_failure_error))
            }
        }
    }

    private fun emitUiState(
        showProgress: Boolean = false,
        movies: Event<List<MovieCollection.Movie>>? = null,
        error: Event<Int>? = null
    ) {
        val dataState = MovieDataState(showProgress, movies, error)
        _uiState.value = dataState
    }
}

data class MovieDataState(
    val showProgress: Boolean,
    val movies: Event<List<MovieCollection.Movie>>?,
    val error: Event<Int>?
)