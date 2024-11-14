package com.example.movies.model;

import java.util.List;

public class Movies {
    private int page;
    private List<Movie> results;
    private int total_pages;

    public int getTotal_results() {
        return total_results;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public List<Movie> getResults() {
        return results;
    }

    public int getPage() {
        return page;
    }

    private int total_results;
}
