/*
 * *
 *  * Created by Candra Ibra Sanie on 11/18/19 10:57 AM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 11/18/19 10:52 AM
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

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TvViewModelTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();
    private TvViewModel viewModel;
    private Repository repository = mock(Repository.class);

    @Before
    public void setUp() {
        viewModel = new TvViewModel(repository);
    }

    @Test
    public void getTvs() {
        ArrayList<TvResults> dummyMovies = FakeDataDummy.generateDummyTvs();

        MutableLiveData<List<TvResults>> tvs = new MutableLiveData<>();
        tvs.setValue(dummyMovies);

        when(repository.mLiveTvData()).thenReturn(tvs);

        Observer<List<TvResults>> observer = mock(Observer.class);

        viewModel.mLiveTvData().observeForever(observer);

        verify(observer).onChanged(dummyMovies);
    }

}