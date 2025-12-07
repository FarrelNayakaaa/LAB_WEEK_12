package com.example.test_lab_week_12

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.test_lab_week_12.model.Movie

@BindingAdapter("list")
fun bindMovies(recyclerView: RecyclerView, list: List<Movie>?) {

    val adapter = recyclerView.adapter as? MovieAdapter
        ?: return  // Adapter belum di-set di Activity → jangan crash

    adapter.addMovies(list ?: emptyList())
}
