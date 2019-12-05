/*
 * *
 *  * Created by Candra Ibra Sanie on 12/5/19 7:02 AM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 12/5/19 7:01 AM
 *
 */

package com.candraibra.catmovie3.service;

import com.candraibra.catmovie3.data.entity.movie.MovieResults;
import com.candraibra.catmovie3.data.entity.tv.TvResults;
import com.candraibra.catmovie3.data.network.movie.MovieResponse;
import com.candraibra.catmovie3.data.network.tv.TvResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TMDBApi {

    //region MOVIE
    // query for movies
    @GET("movie/popular")
    Call<MovieResponse> getMoviePopular(
            @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("page") int page);

    // query for movies upcoming
    @GET("movie/upcoming")
    Call<MovieResponse> getMovieUpcoming(
            @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("page") int page);

    //get_movie_by_id
    @GET("movie/{movie_id}")
    Call<MovieResults> getMovieById(
            @Path("movie_id") int id,
            @Query("api_key") String apiKey,
            @Query("language") String language
    );
    //endregion

    //region TV
    // query for tvs
    @GET("tv/popular")
    Call<TvResponse> getTvPopular(
            @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("page") int page);

    //get_tv_by_id
    @GET("tv/{tv_id}")
    Call<TvResults> getTvById(
            @Path("tv_id") int id,
            @Query("api_key") String apiKey,
            @Query("language") String language
    );
    //endregion
}
