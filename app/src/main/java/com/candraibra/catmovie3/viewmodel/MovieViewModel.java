/*
 * *
 *  * Created by Candra Ibra Sanie on 12/5/19 7:29 AM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 12/5/19 7:10 AM
 *
 */

package com.candraibra.catmovie3.viewmodel;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.candraibra.catmovie3.data.Repository;
import com.candraibra.catmovie3.data.entity.movie.MovieResults;

import java.util.List;

public class MovieViewModel extends ViewModel {
    protected MutableLiveData<List<MovieResults>> movieResults = new MutableLiveData<>();
    protected MutableLiveData<List<MovieResults>> movieResults2 = new MutableLiveData<>();
    private Repository repository;

    MovieViewModel(@NonNull Repository repository) {
        this.repository = repository;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d("xxx", "data cleared");
    }

    public LiveData<List<MovieResults>> mLiveMovieData() {
        if (movieResults.getValue() == null) {
            repository.mLiveMovieData(movieResults);
        }
        return movieResults;
    }

    public LiveData<List<MovieResults>> mLiveUpcomingMovie() {
        if (movieResults2.getValue() == null) {
            repository.mLiveMovieDataUpcoming(movieResults2);
        }
        return movieResults2;
    }
}
