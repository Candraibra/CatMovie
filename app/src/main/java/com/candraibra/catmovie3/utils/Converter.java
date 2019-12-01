/*
 * *
 *  * Created by Candra Ibra Sanie on 12/1/19 4:40 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 12/1/19 4:40 PM
 *
 */

package com.candraibra.catmovie3.utils;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class Converter {
    @TypeConverter()
    public String genretoJson(List<Integer> data) {
        return new Gson().toJson(data);
    }

    @TypeConverter()
    public String generateJsontoData(String data) {
        return new Gson().fromJson(data, new TypeToken<List<Integer>>() {
        }.getType());
    }
}
