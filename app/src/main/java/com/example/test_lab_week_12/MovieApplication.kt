package com.example.test_lab_week_12

import android.app.Application
import androidx.room.Room
import com.example.test_lab_week_12.api.MovieService
import com.example.test_lab_week_12.data.MovieRepository
import com.example.test_lab_week_12.data.local.MovieDatabase
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MovieApplication : Application() {

    lateinit var movieRepository: MovieRepository
    private lateinit var database: MovieDatabase

    override fun onCreate() {
        super.onCreate()

        // --- 1. Moshi ---
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        // --- 2. Retrofit ---
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

        val movieService = retrofit.create(MovieService::class.java)

        // --- 3. Room Database ---
        database = Room.databaseBuilder(
            applicationContext,
            MovieDatabase::class.java,
            "movies.db"
        ).build()

        // --- 4. Repository (Retrofit + Room DAO) ---
        movieRepository = MovieRepository(
            movieService,
            database.movieDao()
        )
    }
}
