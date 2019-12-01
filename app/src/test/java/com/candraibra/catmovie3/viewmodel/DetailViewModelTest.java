/*
 * *
 *  * Created by Candra Ibra Sanie on 11/18/19 4:20 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 11/18/19 4:20 PM
 *
 */

package com.candraibra.catmovie3.viewmodel;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.candraibra.catmovie3.data.Repository;
import com.candraibra.catmovie3.data.entity.movie.MovieResults;
import com.candraibra.catmovie3.data.entity.tv.TvResults;
import com.candraibra.catmovie3.utils.FakeDataDummy;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DetailViewModelTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private DetailViewModel viewModel;
    private Repository repository = mock(Repository.class);
    private MovieResults dummyMovie = FakeDataDummy.generateDummyMovies().get(0);
    private Integer movieId = dummyMovie.getId();

    private TvResults dummyTv = FakeDataDummy.generateDummyTvs().get(0);
    private Integer tvId = dummyTv.getId();


    @Before
    public void setUp() {
        viewModel = new DetailViewModel(repository);
        viewModel.setMovieId(movieId);
        viewModel.setTvId(tvId);
    }

    @Test
    public void getMovieById() {
        MutableLiveData<MovieResults> movieResult = new MutableLiveData<>();
        movieResult.setValue(dummyMovie);

        when(repository.mLiveMovieDataById(movieId)).thenReturn(movieResult);

        Observer<MovieResults> observer = mock(Observer.class);

        viewModel.getMovieById().observeForever(observer);

        verify(observer).onChanged(dummyMovie);
    }


    @Test
    public void getTvById() {
        MutableLiveData<TvResults> tvResult = new MutableLiveData<>();
        tvResult.setValue(dummyTv);

        when(repository.mLiveTvDataById(tvId)).thenReturn(tvResult);

        Observer<TvResults> observer = mock(Observer.class);

        viewModel.getTvById().observeForever(observer);

        verify(observer).onChanged(dummyTv);
    }

}