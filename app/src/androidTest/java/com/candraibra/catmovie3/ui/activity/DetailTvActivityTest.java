/*
 * *
 *  * Created by Candra Ibra Sanie on 12/2/19 7:44 AM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 12/2/19 7:39 AM
 *
 */

package com.candraibra.catmovie3.ui.activity;

import android.content.Context;
import android.content.Intent;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import com.candraibra.catmovie3.R;
import com.candraibra.catmovie3.data.entity.tv.TvResults;
import com.candraibra.catmovie3.utils.EspressoIdlingResource;
import com.candraibra.catmovie3.utils.FakeDataDummy;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class DetailTvActivityTest {
    private TvResults dummyTv = FakeDataDummy.generateDummyTvs().get(0);

    @Rule
    public ActivityTestRule<DetailTvActivity> activityRule = new ActivityTestRule<DetailTvActivity>(DetailTvActivity.class) {
        @Override
        protected Intent getActivityIntent() {
            Context targetContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
            Intent result = new Intent(targetContext, DetailTvActivity.class);
            result.putExtra(DetailTvActivity.EXTRA_TV, dummyTv);
            return result;

        }
    };

    @Before
    public void setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource());
    }

    @After
    public void tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResource());
    }

    @Test
    public void loadDetailTv() {
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_title)).check(matches(withText(dummyTv.getName())));
        onView(withId(R.id.tv_desc)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_desc)).check(matches(withText(dummyTv.getOverview())));
        onView(withId(R.id.img_poster)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_fav)).perform(click());
    }
}