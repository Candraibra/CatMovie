/*
 * *
 *  * Created by Candra Ibra Sanie on 12/2/19 8:32 AM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 12/2/19 8:32 AM
 *
 */

package com.candraibra.catmovie3.ui.fragment;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.rule.ActivityTestRule;

import com.candraibra.catmovie3.R;
import com.candraibra.catmovie3.testing.SingleFragmentActivity;
import com.candraibra.catmovie3.ui.adapter.MoviePagedListAdapter;
import com.candraibra.catmovie3.ui.adapter.TvPagedListAdapter;
import com.candraibra.catmovie3.utils.EspressoIdlingResource;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class FavoriteFragmentTest {
    @Rule
    public ActivityTestRule<SingleFragmentActivity> activityRule = new ActivityTestRule<>(SingleFragmentActivity.class);
    private FavoriteFragment favoriteFragment = new FavoriteFragment();
    private MoviePagedListAdapter moviePagedListAdapter;
    private TvPagedListAdapter tvPagedListAdapter;

    @Before
    public void setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource());
        activityRule.getActivity().setFragment(favoriteFragment);
    }

    @After
    public void tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResource());
    }

    @Test
    public void loadMovie() {
        onView(withId(R.id.toolbar)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_tv)).check(matches(isDisplayed()));
    }

}