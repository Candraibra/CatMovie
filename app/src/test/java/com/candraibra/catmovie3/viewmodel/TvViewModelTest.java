/*
 * *
 *  * Created by Candra Ibra Sanie on 12/2/19 7:44 AM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 12/2/19 7:43 AM
 *
 */

package com.candraibra.catmovie3.viewmodel;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.candraibra.catmovie3.data.Repository;
import com.candraibra.catmovie3.data.entity.tv.TvResults;
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

public class TvViewModelTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();
    private TvViewModel viewModel;
    private Repository repository = mock(Repository.class);

    @Before
    public void setUp() {
        viewModel = spy(new TvViewModel(repository));
    }

    @Test
    public void getTvs() {
        ArrayList<TvResults> dummyMovies = FakeDataDummy.generateDummyTvs();

        MutableLiveData<List<TvResults>> tvs = new MutableLiveData<>();
        tvs.setValue(dummyMovies);

        Observer<List<TvResults>> observer = mock(Observer.class);
        viewModel.tvResults = tvs;

        viewModel.tvResults.observeForever(observer);

        assertEquals(viewModel.tvResults, viewModel.mLiveTvData());

        verify(observer).onChanged(dummyMovies);
    }

}