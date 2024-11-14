package com.example.movies.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.movies.R;
import com.example.movies.databinding.FragmentMovieDetailsBinding;
import com.example.movies.viewmodel.MovieViewModel;

public class MovieDetails extends Fragment {

    private FragmentMovieDetailsBinding binding;
    private MovieViewModel movieViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMovieDetailsBinding.inflate(getLayoutInflater());

        movieViewModel = new ViewModelProvider(requireActivity()).get(MovieViewModel.class);

        Bundle args = getArguments();
        if (args != null) {
            int movieId = args.getInt("movieId", -1);
            if (movieId != -1) {
                movieViewModel.getSpecificMovie(movieId);
            }
        }
        movieViewModel.getMovieDetails().observe(getViewLifecycleOwner(), movieDetails -> {
            if (movieDetails != null) {
                binding.setMovie(movieDetails);
            }
        });

        return binding.getRoot();
    }
}