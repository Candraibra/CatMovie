/*
 * *
 *  * Created by Candra Ibra Sanie on 11/28/19 11:12 AM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 11/24/19 5:41 PM
 *
 */

package com.candraibra.catmovie3.service;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.candraibra.catmovie3.BuildConfig;
import com.candraibra.catmovie3.data.network.movie.MovieResponse;
import com.candraibra.catmovie3.data.network.movie.MovieResults;
import com.candraibra.catmovie3.data.network.tv.TvResponse;
import com.candraibra.catmovie3.data.network.tv.TvResults;
import com.candraibra.catmovie3.utils.EspressoIdlingResource;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NetworkCall {
    private static final String LANGUAGE = "en-US";
    private static NetworkCall INSTANCE;
    private static TMDBApi apiClient = ApiClient.getClient().create(TMDBApi.class);

    private Application application;

    private NetworkCall(Application application) {
        this.application = application;
    }

    public static NetworkCall getInstance(Application application) {
        if (INSTANCE == null) {
            INSTANCE = new NetworkCall(application);
        }
        return INSTANCE;
    }

    public LiveData<List<TvResults>> getPopularTv() {
        EspressoIdlingResource.increment();
        MutableLiveData<List<TvResults>> tvData = new MutableLiveData<>();
        Call<TvResponse> tvResponseCall = apiClient.getTvPopular(BuildConfig.ApiKey, LANGUAGE, 1);
        tvResponseCall.enqueue(new Callback<TvResponse>() {
            @Override
            public void onResponse(@NotNull Call<TvResponse> call, @NotNull Response<TvResponse> response) {
                if (response.isSuccessful()) {
                    TvResponse tvResponse = response.body();
                    if (tvResponse != null && tvResponse.getResults() != null) {
                        tvData.postValue(tvResponse.getResults());
                    } else {
                        Log.d("NetworkCall", "Empty Data");
                    }
                }
            }

            @Override
            public void onFailure(@NotNull Call<TvResponse> call, @NotNull Throwable t) {
                Log.d("NetworkCall", "Failed Fetch getPopularMovie()/Failure");
            }
        });
        EspressoIdlingResource.decrement();
        return tvData;
    }

//    public static LiveData<List<MovieResults>> getDataMovie() {
//        return movieData;
//    }
//
//    public static LiveData<List<TvResults>> getDataTv() {
//        return tvData;
//    }

    public LiveData<List<MovieResults>> getPopularMovie() {
        EspressoIdlingResource.increment();
        MutableLiveData<List<MovieResults>> movieData = new MutableLiveData<>();
        Call<MovieResponse> call = apiClient.getMoviePopular(BuildConfig.ApiKey, LANGUAGE, 1);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(@NotNull Call<MovieResponse> call, @NotNull Response<MovieResponse> response) {
                if (response.isSuccessful()) {
                    MovieResponse moviesResponse = response.body();
                    if (moviesResponse != null && moviesResponse.getResults() != null) {
                        movieData.postValue(moviesResponse.getResults());
                    } else {
                        Log.d("NetworkCall", "Empty Data");
                    }
                }
            }

            @Override
            public void onFailure(@NotNull Call<MovieResponse> call, @NotNull Throwable t) {
                Log.d("NetworkCall", "Failed Fetch getPopularMovie()/Failure");
            }
        });
        EspressoIdlingResource.decrement();
        return movieData;

    }

    public LiveData<MovieResults> getMovieById(int id) {
        EspressoIdlingResource.increment();
        MutableLiveData<MovieResults> movieDataById = new MutableLiveData<>();
        Call<MovieResults> movieResultsCall = apiClient.getMovieById(id, BuildConfig.ApiKey, LANGUAGE);
        movieResultsCall.enqueue(new Callback<MovieResults>() {
            @Override
            public void onResponse(@NotNull Call<MovieResults> call, @NotNull Response<MovieResults> response) {
                if (response.isSuccessful()) {
                    MovieResults movieResults = response.body();
                    if (movieResults != null) {
                        movieDataById.postValue(movieResults);
                    } else {
                        Log.d("NetworkCall", "Empty Data");
                    }
                }
            }

            @Override
            public void onFailure(@NotNull Call<MovieResults> call, @NotNull Throwable t) {
                Log.d("NetworkCall", "Failed Fetch getPopularMovie()/Failure");
            }
        });
        EspressoIdlingResource.decrement();
        return movieDataById;

    }

    public LiveData<TvResults> getTvById(int id) {
        EspressoIdlingResource.increment();
        MutableLiveData<TvResults> tvDataById = new MutableLiveData<>();
        Call<TvResults> tvResultsCall = apiClient.getTvById(id, BuildConfig.ApiKey, LANGUAGE);
        tvResultsCall.enqueue(new Callback<TvResults>() {
            @Override
            public void onResponse(@NotNull Call<TvResults> call, @NotNull Response<TvResults> response) {
                if (response.isSuccessful()) {
                    TvResults tvResults = response.body();
                    if (tvResults != null) {
                        tvDataById.postValue(tvResults);
                    } else {
                        Log.d("NetworkCall", "Empty Data");
                    }
                }
            }

            @Override
            public void onFailure(@NotNull Call<TvResults> call, @NotNull Throwable t) {
                Log.d("NetworkCall", "Failed Fetch getPopularMovie()/Failure");
            }
        });
        EspressoIdlingResource.decrement();
        return tvDataById;
    }

}
