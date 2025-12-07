package com.example.test_lab_week_12

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.test_lab_week_12.model.Movie

@BindingAdapter("list")
fun bindMovies(view: RecyclerView, movies: List<Movie>?) {
    val adapter = view.adapter as? MovieAdapter
    if (adapter == null) {
        val newAdapter = MovieAdapter()
        view.adapter = newAdapter
        newAdapter.addMovies(movies ?: emptyList())
    } else {
        adapter.addMovies(movies ?: emptyList())
    }
}
