package com.example.test_lab_week_12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.test_lab_week_12.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_TITLE = "title"
        const val EXTRA_RELEASE = "release"
        const val EXTRA_OVERVIEW = "overview"
        const val EXTRA_POSTER = "poster"
    }

    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val title = intent.getStringExtra(EXTRA_TITLE)
        val release = intent.getStringExtra(EXTRA_RELEASE)
        val overview = intent.getStringExtra(EXTRA_OVERVIEW)
        val poster = intent.getStringExtra(EXTRA_POSTER)

        binding.movieTitle.text = title
        binding.movieRelease.text = release
        binding.movieOverview.text = overview

        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w500/$poster")
            .into(binding.moviePoster)
    }
}
