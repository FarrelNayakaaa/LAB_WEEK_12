package com.example.test_lab_week_12.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.test_lab_week_12.data.MovieRepository

class MovieViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    // Week 13 REQUIREMENT:
    val popularMovies = movieRepository.fetchMovies().asLiveData()

    // Error handling
    val error = null
}
