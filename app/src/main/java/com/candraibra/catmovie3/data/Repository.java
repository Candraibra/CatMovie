/*
 * *
 *  * Created by Candra Ibra Sanie on 12/5/19 7:29 AM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 12/5/19 7:10 AM
 *
 */

package com.candraibra.catmovie3.data;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;

import com.candraibra.catmovie3.data.entity.movie.MovieResults;
import com.candraibra.catmovie3.data.entity.tv.TvResults;
import com.candraibra.catmovie3.database.MovieRoomDatabase;
import com.candraibra.catmovie3.database.dao.MovieDao;
import com.candraibra.catmovie3.database.dao.TvDao;
import com.candraibra.catmovie3.service.NetworkCall;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Repository {
    private static Repository INSTANCE;
    private MovieDao movieDao;
    private TvDao tvDao;
    private NetworkCall networkCall;
    private ExecutorService executorService;

    private Repository(NetworkCall networkCall, Application application) {
        this.networkCall = networkCall;
        executorService = Executors.newSingleThreadExecutor();

        MovieRoomDatabase db = MovieRoomDatabase.getDatabase(application);
        movieDao = db.movieDao();
        tvDao = db.tvDao();
    }

    public static Repository getInstance(NetworkCall networkCall, Application application) {

        if (INSTANCE == null) {
            INSTANCE = new Repository(networkCall, application);
        }
        return INSTANCE;

    }

    // Methods for MovieFragment
    public void mLiveMovieData(MutableLiveData<List<MovieResults>> liveData) {
        networkCall.getPopularMovie(liveData);
    }

    // Methods for MovieFragment
    public void mLiveMovieDataUpcoming(MutableLiveData<List<MovieResults>> liveData) {
        networkCall.getUpcomingMovie(liveData);
    }

    // Methods for TvFragment
    public void mLiveTvData(MutableLiveData<List<TvResults>>liveData) {
        networkCall.getPopularTv(liveData);
    }

    // Methods for MovieMovie
    public LiveData<MovieResults> mLiveMovieDataById(Integer id) {
        return networkCall.getMovieById(id);
    }

    // Methods for DetailTv
    public LiveData<TvResults> mLiveTvDataById(Integer id) {
        return networkCall.getTvById(id);
    }

    public DataSource.Factory<Integer, MovieResults> getAllMovie() {
        return movieDao.getAllmovie();
    }

    public DataSource.Factory<Integer, TvResults> getAllTv() {
        return tvDao.getAllTv();
    }

    public LiveData<MovieResults> getMovieByIdRoom(int id) {
        return movieDao.getMovieById(id);
    }

    public LiveData<TvResults> getTvByIdRoom(int id) {
        return tvDao.getTvById(id);
    }


    public void insertMovie(final MovieResults movieResults) {
        executorService.execute(() -> movieDao.insert(movieResults));
    }

    public void deleteMovie(final MovieResults movieResults) {
        executorService.execute(() -> movieDao.delete(movieResults));
    }

    public void insertTv(final TvResults tvResults) {
        executorService.execute(() -> tvDao.insert(tvResults));
    }

    public void deleteTv(final TvResults tvResults) {
        executorService.execute(() -> tvDao.delete(tvResults));
    }
}
