package com.example.test_lab_week_12.data

import com.example.test_lab_week_12.api.MovieService
import com.example.test_lab_week_12.data.local.MovieDao
import com.example.test_lab_week_12.data.local.MovieEntity
import com.example.test_lab_week_12.model.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.flatMapLatest

class MovieRepository(
    private val movieService: MovieService,
    private val movieDao: MovieDao
) {
    fun getMovies(): Flow<List<Movie>> = flow {
        // Ambil dari API
        val response = movieService.getPopularMovies("f2b50d545ba36e3506a9182391d58c84")

        // Convert ke Room entity
        val entities = response.results.map {
            MovieEntity(
                id = it.id,
                title = it.title,
                releaseDate = it.releaseDate,
                overview = it.overview,
                posterPath = it.posterPath,
                popularity = it.popularity
            )
        }

        // Simpan ke database
        movieDao.insertMovies(entities)

        // Emit dari database
        emit(movieDao.getAllMovies().map {
            Movie(
                id = it.id,
                title = it.title,
                releaseDate = it.releaseDate,
                overview = it.overview,
                posterPath = it.posterPath,
                popularity = it.popularity
            )
        })
    }
}

