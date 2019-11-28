/*
 * *
 *  * Created by Candra Ibra Sanie on 11/28/19 11:12 AM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 11/18/19 4:20 PM
 *
 */

package com.candraibra.catmovie3.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.candraibra.catmovie3.data.Repository;
import com.candraibra.catmovie3.data.network.movie.MovieResults;
import com.candraibra.catmovie3.data.network.tv.TvResults;

public class DetailViewModel extends ViewModel {

    private Integer movieId;
    private Integer tvId;
    private Repository repository;

    DetailViewModel(Repository repository) {
        this.repository = repository;
    }

    public Integer getTvId() {
        return tvId;
    }

    public void setTvId(Integer tvId) {
        this.tvId = tvId;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d("xxx", "data cleared");
    }

    public LiveData<MovieResults> getMovieById() {
        return repository.mLiveMovieDataById(movieId);
    }

    public LiveData<TvResults> getTvById() {
        return repository.mLiveTvDataById(tvId);
    }

}
