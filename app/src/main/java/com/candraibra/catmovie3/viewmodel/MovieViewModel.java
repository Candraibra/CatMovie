/*
 * *
 *  * Created by Candra Ibra Sanie on 11/28/19 11:12 AM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 11/18/19 11:01 AM
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

import java.util.ArrayList;
import java.util.List;

public class MovieViewModel extends ViewModel {
    private Repository repository;
    private MutableLiveData<List<MovieResults>> movieResults = new MutableLiveData<>();

    MovieViewModel(@NonNull Repository repository) {
        this.repository = repository;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d("xxx", "data cleared");
    }

    public LiveData<List<MovieResults>> mLiveMovieData() {
        if (movieResults.getValue() == null){
            repository.mLiveMovieData(movieResults);
        }
        return movieResults;
    }
}
