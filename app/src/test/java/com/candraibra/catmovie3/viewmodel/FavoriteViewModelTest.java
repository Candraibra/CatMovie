/*
 * *
 *  * Created by Candra Ibra Sanie on 12/2/19 7:44 AM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 12/2/19 7:00 AM
 *
 */

package com.candraibra.catmovie3.viewmodel;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.paging.DataSource;
import androidx.paging.PagedList;

import com.candraibra.catmovie3.data.Repository;
import com.candraibra.catmovie3.data.entity.movie.MovieResults;
import com.candraibra.catmovie3.data.entity.tv.TvResults;
import com.candraibra.catmovie3.utils.FakeDataDummy;
import com.candraibra.catmovie3.utils.PagedListUtil;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class FavoriteViewModelTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();
    private FavoriteViewModel viewModel;
    private Repository repository = mock(Repository.class);


    @Before
    public void setUp() {
        viewModel = new FavoriteViewModel(repository);
    }

    @Test
    public void getAllMovie() {
        ArrayList<MovieResults> movieResults = FakeDataDummy.generateDummyMovies();
        DataSource.Factory<Integer, MovieResults> dataSourceFactory = mock(DataSource.Factory.class);

        when(repository.getAllMovie()).thenReturn(dataSourceFactory);
        PagedList<MovieResults> result = PagedListUtil.mockPagedList(movieResults);

        repository.getAllMovie();

        verify(repository).getAllMovie();
        assertNotNull(result);
        assertEquals(movieResults.size(), result.size());
    }

    @Test
    public void getAllTv() {
        ArrayList<TvResults> tvResults = FakeDataDummy.generateDummyTvs();
        DataSource.Factory<Integer, TvResults> dataSourceFactory = mock(DataSource.Factory.class);

        when(repository.getAllTv()).thenReturn(dataSourceFactory);
        PagedList<TvResults> result = PagedListUtil.mockPagedList(tvResults);

        repository.getAllTv();

        verify(repository).getAllTv();
        assertNotNull(result);
        assertEquals(tvResults.size(), result.size());
    }
}