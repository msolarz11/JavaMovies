package com.example.movies.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.movies.model.Movie;
import com.example.movies.model.MovieDetails;
import com.example.movies.model.Movies;
import com.example.movies.service.RetrofitService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieViewModel extends ViewModel {
    private String apiKey = "";
    private MutableLiveData<Movies> mutableMoviesList;
    private MutableLiveData<MovieDetails> movieDetails;


    public MutableLiveData<MovieDetails> getMovieDetails() {
        return movieDetails;
    }


    public MovieViewModel() {
        this.mutableMoviesList = new MutableLiveData<>();
        this.movieDetails = new MutableLiveData<>();
    }

    public void getPopularMovies() {

        Call<Movies> call = RetrofitService
                .getMovieInterface()
                .getPopularMovies("3e01442495d6c0363356bd92401a6367");

        call.enqueue(new Callback<Movies>() {
            @Override
            public void onResponse(Call<Movies> call, Response<Movies> response) {
                mutableMoviesList.setValue(response.body());
                List<Movie> movies = response.body().getResults();
                for(Movie movie: movies){
                    Log.d("xxx", movie.toString());
                }
                Log.d("xxx", "abc");

            }

            @Override
            public void onFailure(Call<Movies> call, Throwable t) {
                Log.d("xxx", "onFailure:" + t);
            }
        });

    }

    public void getSpecificMovie(int id){
        Call<MovieDetails> call = RetrofitService.getMovieInterface().getSpecificMovie(id, "3e01442495d6c0363356bd92401a6367");
        call.enqueue(new Callback<MovieDetails>() {
            @Override
            public void onResponse(Call<MovieDetails> call, Response<MovieDetails> response) {
                if(response.isSuccessful()){
                    movieDetails.setValue(response.body());
                }else{

                }
            }

            @Override
            public void onFailure(Call<MovieDetails> call, Throwable throwable) {

            }
        });
    }


    // observed movies

    public MutableLiveData<Movies> getObservedMovies() {
        return mutableMoviesList;
    }
}
