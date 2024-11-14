package com.example.movies.model;

public class MovieDetails {
    private int id;
    private String title;

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

    public int getVote_count() {
        return vote_count;
    }

    public String getOverview() {
        return overview;
    }

    private String poster_path;
    private Double vote_average;
    private int vote_count;
    private String overview;
}
