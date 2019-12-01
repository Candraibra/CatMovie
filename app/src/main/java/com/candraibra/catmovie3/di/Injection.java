/*
 * *
 *  * Created by Candra Ibra Sanie on 11/28/19 11:12 AM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 11/18/19 11:01 AM
 *
 */

package com.candraibra.catmovie3.di;

import android.app.Application;

import com.candraibra.catmovie3.data.Repository;
import com.candraibra.catmovie3.service.NetworkCall;

public class Injection {
    public static Repository provideRepository(Application application) {
        NetworkCall networkCall = NetworkCall.getInstance();
        return Repository.getInstance(networkCall,application);
    }
}
