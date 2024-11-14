package com.example.movies.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.movies.databinding.ListItemBinding;
import com.example.movies.model.Movie;
import com.example.movies.viewmodel.MovieViewModel;

import java.util.List;

public class MovieAdapter extends BaseAdapter {

    private MovieViewModel movieViewModel;
    private LayoutInflater layoutInflater;
    private OnMovieClickListener onMovieClickListener;

    public MovieAdapter(MovieViewModel movieViewModel, OnMovieClickListener listener) {
        this.movieViewModel = movieViewModel;
        this.onMovieClickListener = listener;
    }

    @Override
    public int getCount() {
        return movieViewModel.getObservedMovies().getValue().getResults() != null ? movieViewModel.getObservedMovies().getValue().getResults().size() : 0;
    }

    @Override
    public Movie getItem(int i) {
        return movieViewModel.getObservedMovies().getValue().getResults().get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        View root = convertView;

        ListItemBinding binding;
        if (root == null) {
            if (layoutInflater == null) {
                layoutInflater
                        = (LayoutInflater) viewGroup.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            }
            binding = ListItemBinding.inflate(layoutInflater, viewGroup, false);
            root = binding.getRoot();
            root.setTag(binding);
            binding.main.setOnClickListener(v->{
                if (onMovieClickListener != null) {
                    onMovieClickListener.onMovieClick(movieViewModel.getObservedMovies().getValue().getResults().get(position));
                }
                movieViewModel.getSpecificMovie(movieViewModel.getObservedMovies().getValue().getResults().get(position).getId());
            });

        } else {
            binding = (ListItemBinding) root.getTag();
        }
        binding.setMovie(getItem(position));

        return root;

    }

    public interface OnMovieClickListener {
        void onMovieClick(Movie movie);
    }

}