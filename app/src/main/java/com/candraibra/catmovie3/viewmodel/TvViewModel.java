/*
 * *
 *  * Created by Candra Ibra Sanie on 12/2/19 7:44 AM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 12/1/19 10:59 PM
 *
 */

package com.candraibra.catmovie3.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.candraibra.catmovie3.data.Repository;
import com.candraibra.catmovie3.data.entity.tv.TvResults;

import java.util.List;

public class TvViewModel extends ViewModel {
    private Repository repository;
    protected MutableLiveData<List<TvResults>> tvResults = new MutableLiveData<>();


    TvViewModel(Repository repository) {
        this.repository = repository;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d("xxx", "data cleared");
    }

    public LiveData<List<TvResults>> mLiveTvData() {
        if (tvResults.getValue() == null) {
            repository.mLiveTvData(tvResults);
        }
        return tvResults;
    }

}
