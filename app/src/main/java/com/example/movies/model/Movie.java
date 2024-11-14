package com.example.movies.model;

public class Movie {
    private int id;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public Double getVote_average() {
        return vote_average;
    }

    private String title;
    private String poster_path;
    private Double vote_average;

}
