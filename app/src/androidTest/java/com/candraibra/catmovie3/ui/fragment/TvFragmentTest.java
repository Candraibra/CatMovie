/*
 * *
 *  * Created by Candra Ibra Sanie on 12/3/19 12:28 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 12/3/19 11:45 AM
 *
 */

package com.candraibra.catmovie3.ui.fragment;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.rule.ActivityTestRule;

import com.candraibra.catmovie3.R;
import com.candraibra.catmovie3.testing.SingleFragmentActivity;
import com.candraibra.catmovie3.utils.EspressoIdlingResource;
import com.candraibra.catmovie3.utils.RecyclerViewItemCountAssertion;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class TvFragmentTest {
    @Rule
    public ActivityTestRule<SingleFragmentActivity> activityRule = new ActivityTestRule<>(SingleFragmentActivity.class);
    private TvFragment tvFragment = new TvFragment();

    @Before
    public void setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource());
        activityRule.getActivity().setFragment(tvFragment);
    }

    @After
    public void tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResource());
    }

    @Test
    public void loadTv() {
        onView(withId(R.id.toolbar)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_tv)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_tv)).check(new RecyclerViewItemCountAssertion(20));
        onView(withId(R.id.rv_tv)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.btn_fav)).perform(click());
    }
}