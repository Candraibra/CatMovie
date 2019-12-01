/*
 * *
 *  * Created by Candra Ibra Sanie on 12/1/19 11:41 AM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 12/1/19 11:41 AM
 *
 */

package com.candraibra.catmovie3.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.candraibra.catmovie3.data.entity.movie.MovieResults;
import com.candraibra.catmovie3.data.entity.tv.TvResults;

import java.util.List;

@Dao
public interface TvDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(TvResults tv);

    @Update()
    void update(TvResults tv);

    @Delete()
    void delete(TvResults tv);

    @Query("SELECT * from tvresults ORDER BY name ASC")
    LiveData<List<TvResults>> getAllTv();
}
