/*
 * *
 *  * Created by Candra Ibra Sanie on 12/26/19 7:37 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 12/26/19 7:37 PM
 *
 */

package com.candraibra.catmovie3.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.candraibra.catmovie3.data.Repository;
import com.candraibra.catmovie3.data.entity.movie.MovieResults;
import com.candraibra.catmovie3.data.entity.tv.TvResults;

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

    public LiveData<TvResults> getTvByIdRoom() {
        return repository.getTvByIdRoom(tvId);
    }

    public void insertTv(TvResults tvResults) {
        repository.insertTv(tvResults);
    }

    public void deleteTv(TvResults tvResults) {
        repository.deleteTv(tvResults);
    }

    public LiveData<MovieResults> getMovieByIdRoom() {
        return repository.getMovieByIdRoom(movieId);
    }

    public void insertMovie(MovieResults movieResults) {
        repository.insertMovie(movieResults);
    }

    public void deleteMovie(MovieResults movieResults) {
        repository.deleteMovie(movieResults);
    }

}
