/*
 * *
 *  * Created by Candra Ibra Sanie on 12/2/19 7:44 AM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 12/1/19 11:24 PM
 *
 */

package com.candraibra.catmovie3.viewmodel;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.candraibra.catmovie3.data.Repository;
import com.candraibra.catmovie3.data.entity.movie.MovieResults;
import com.candraibra.catmovie3.utils.FakeDataDummy;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class MovieViewModelTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();
    private MovieViewModel viewModel;
    private Repository repository = mock(Repository.class);

    @Before
    public void setUp() {
        viewModel = spy(new MovieViewModel(repository));
    }

    @Test
    public void getMovies() {
        ArrayList<MovieResults> dummyMovies = FakeDataDummy.generateDummyMovies();

        MutableLiveData<List<MovieResults>> movies = new MutableLiveData<>();
        movies.setValue(dummyMovies);

        Observer<List<MovieResults>> observer = mock(Observer.class);
        viewModel.movieResults = movies;

        viewModel.movieResults.observeForever(observer);
        assertEquals(viewModel.movieResults, viewModel.mLiveMovieData());

        verify(observer).onChanged(dummyMovies);

    }

}