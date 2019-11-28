/*
 * *
 *  * Created by Candra Ibra Sanie on 11/18/19 10:57 AM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 11/15/19 11:22 AM
 *
 */

package com.candraibra.catmovie3.utils;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class LiveDataTestUtil {
    @SuppressWarnings("unchecked")
    public static <T> T getValue(LiveData<T> liveData) {
        Object[] data = new Object[1];
        CountDownLatch latch = new CountDownLatch(1);

        Observer<T> observer = new Observer<T>() {
            @Override
            public void onChanged(T o) {
                data[0] = o;
                latch.countDown();
                liveData.removeObserver(this);
            }
        };

        liveData.observeForever(observer);

        try {
            latch.await(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return (T) data[0];

    }
}
