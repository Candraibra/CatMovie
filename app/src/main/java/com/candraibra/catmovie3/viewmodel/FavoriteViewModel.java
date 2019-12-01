/*
 * *
 *  * Created by Candra Ibra Sanie on 12/1/19 10:03 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 12/1/19 9:26 PM
 *
 */

package com.candraibra.catmovie3.viewmodel;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.candraibra.catmovie3.data.Repository;
import com.candraibra.catmovie3.data.entity.movie.MovieResults;
import com.candraibra.catmovie3.data.entity.tv.TvResults;

public class FavoriteViewModel extends ViewModel {
    private Repository repository;

    FavoriteViewModel(@NonNull Repository repository) {
        this.repository = repository;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d("xxx", "data cleared");
    }

    public LiveData<PagedList<MovieResults>> getAllMovie() {
        return new LivePagedListBuilder<>(repository.getAllMovie(), 10).build();
    }

    public LiveData<PagedList<TvResults>> getAllTv() {
        return new LivePagedListBuilder<>(repository.getALlTv(), 10).build();
    }

}
