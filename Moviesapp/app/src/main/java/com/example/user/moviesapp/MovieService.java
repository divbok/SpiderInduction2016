package com.example.user.moviesapp;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by user on 7/23/2016.
 */
public interface MovieService {
    @GET("?")
    Observable<Movie> getMovieData(@Query("t") String search);
}
