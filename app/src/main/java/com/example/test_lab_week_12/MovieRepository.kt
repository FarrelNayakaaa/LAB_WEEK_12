package com.example.test_lab_week_12.data

import com.example.test_lab_week_12.api.MovieService
import com.example.test_lab_week_12.model.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class MovieRepository(private val movieService: MovieService) {

    private val apiKey = "f2b50d545ba36e3506a9182391d58c84"

    // Tidak ada lagi LiveData

    // Menggunakan Flow
    fun fetchMovies(): Flow<List<Movie>> {
        return flow {
            val response = movieService.getPopularMovies(apiKey)
            emit(response.results)   // mengirim list keluar sebagai stream
        }.flowOn(Dispatchers.IO)
    }
}
