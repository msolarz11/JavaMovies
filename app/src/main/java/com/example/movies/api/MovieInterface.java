package com.example.movies.api;

import com.example.movies.model.Movie;
import com.example.movies.model.MovieDetails;
import com.example.movies.model.Movies;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Path;

public interface MovieInterface {

    @GET("popular")
    Call<Movies> getPopularMovies(@Query("api_key") String api_key);
    @GET("{id}")
    Call<MovieDetails> getSpecificMovie(@Path("id") int id, @Query("api_key") String api_key);
}