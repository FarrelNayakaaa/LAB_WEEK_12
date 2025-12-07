package com.example.test_lab_week_12.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test_lab_week_12.data.MovieRepository
import com.example.test_lab_week_12.model.Movie
import kotlinx.coroutines.launch

class MovieViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    val popularMovies = MutableLiveData<List<Movie>>()
    val error = MutableLiveData<String?>()

    init {
        loadMovies()
    }

    private fun loadMovies() {
        viewModelScope.launch {
            try {
                movieRepository.getMovies().collect {
                    popularMovies.postValue(it)
                }
            } catch (e: Exception) {
                error.postValue(e.message)
            }
        }
    }
}
