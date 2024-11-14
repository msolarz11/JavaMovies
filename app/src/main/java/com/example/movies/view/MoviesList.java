package com.example.movies.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.movies.R;
import com.example.movies.adapters.MovieAdapter;
import com.example.movies.databinding.FragmentMovieDetailsBinding;
import com.example.movies.databinding.FragmentMoviesListBinding;
import com.example.movies.model.Movie;
import com.example.movies.viewmodel.MovieViewModel;
import com.example.movies.adapters.MovieAdapter;


public class MoviesList extends Fragment implements MovieAdapter.OnMovieClickListener {
    private FragmentMoviesListBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMoviesListBinding.inflate(getLayoutInflater());
        MovieViewModel movieViewModel = new ViewModelProvider(this).get(MovieViewModel.class);
        MovieAdapter adapter;
        movieViewModel.getPopularMovies();
        binding.setMovieViewModel(movieViewModel);

        adapter = new MovieAdapter(movieViewModel, this);

        movieViewModel.getPopularMovies();
        movieViewModel.getObservedMovies().observe(getViewLifecycleOwner(), l -> {
            binding.gridView.setAdapter(adapter);
        });

        return binding.getRoot();



    }

    @Override
    public void onMovieClick(Movie movie) {
        navigateToMovieDetails(movie);
    }

    private void navigateToMovieDetails(Movie movie) {
        Fragment movieDetailsFragment = new MovieDetails();

        Bundle bundle = new Bundle();
        bundle.putInt("movieId", movie.getId());
        movieDetailsFragment.setArguments(bundle);

        FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame, movieDetailsFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}