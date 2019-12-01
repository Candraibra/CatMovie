/*
 * *
 *  * Created by Candra Ibra Sanie on 11/28/19 11:12 AM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 11/18/19 11:01 AM
 *
 */

package com.candraibra.catmovie3.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.candraibra.catmovie3.data.Repository;
import com.candraibra.catmovie3.data.entity.tv.TvResults;

import java.util.List;

public class TvViewModel extends ViewModel {
    private Repository repository;


    TvViewModel(Repository repository) {
        this.repository = repository;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d("xxx", "data cleared");
    }

    public LiveData<List<TvResults>> mLiveTvData() {
        return repository.mLiveTvData();
    }

}
