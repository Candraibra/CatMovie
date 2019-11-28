/*
 * *
 *  * Created by Candra Ibra Sanie on 11/18/19 10:57 AM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 11/18/19 10:32 AM
 *
 */

package com.candraibra.catmovie3.viewmodel;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.candraibra.catmovie3.data.Repository;
import com.candraibra.catmovie3.data.network.movie.MovieResults;
import com.candraibra.catmovie3.utils.FakeDataDummy;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MovieViewModelTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();
    private MovieViewModel viewModel;
    private Repository repository = mock(Repository.class);

    @Before
    public void setUp() {
        viewModel = new MovieViewModel(repository);
    }

    @Test
    public void getMovies() {
        ArrayList<MovieResults> dummyMovies = FakeDataDummy.generateDummyMovies();

        MutableLiveData<List<MovieResults>> movies = new MutableLiveData<>();
        movies.setValue(dummyMovies);

        when(repository.mLiveMovieData()).thenReturn(movies);

        Observer<List<MovieResults>> observer = mock(Observer.class);

        viewModel.mLiveMovieData().observeForever(observer);

        verify(observer).onChanged(dummyMovies);
    }

}